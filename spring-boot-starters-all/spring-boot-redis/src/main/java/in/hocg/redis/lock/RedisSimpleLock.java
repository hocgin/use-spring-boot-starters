package in.hocg.redis.lock;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by hocgin on 2019/4/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Component
public class RedisSimpleLock {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    private final static String LOCK_PREFIX = "LOCK_PREFIX_";
    
    
    /**
     * 获取锁
     *
     * @param lockName
     * @param timeout
     * @param unit
     * @return
     */
    public boolean lock(@NonNull String lockName, int timeout, TimeUnit unit) {
        String key = LOCK_PREFIX + lockName;
        // 当前时间
        long currentTime = System.currentTimeMillis();
        // 最长时间
        long releaseTime = currentTime + unit.toMillis(timeout) + 1;
        
        ValueOperations<String, Long> ops = redisTemplate.opsForValue();
        
        // 第一次获取
        if (ops.setIfAbsent(key, releaseTime)) {
            redisTemplate.expire(key, timeout, unit);
            return true;
        }
        Optional<Long> valOptional = Optional.ofNullable(ops.get(key));
        
        if (valOptional.isPresent()) {
            Long val = valOptional.get();
            
            // 锁已经过期
            if (val < currentTime) {
                Long andSet = ops.getAndSet(key, releaseTime);
                return Objects.equals(andSet, val);
            }
        }
        
        return false;
    }
    
    /**
     * 解除锁
     *
     * @param lockName
     */
    public void unlock(String lockName) {
        String key = LOCK_PREFIX + lockName;
        ValueOperations<String, Long> ops = redisTemplate.opsForValue();
        ops.getOperations().delete(key);
    }
    
}
