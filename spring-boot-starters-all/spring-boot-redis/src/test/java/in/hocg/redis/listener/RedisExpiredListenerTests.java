package in.hocg.redis.listener;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Created by hocgin on 2019/4/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisExpiredListenerTests {
    @Autowired
    private RedisTemplate redisTemplate;
    
    /**
     * 检测过期监听器
     * @throws InterruptedException
     */
    @Test
    public void setExpiredKey() throws InterruptedException {
        ValueOperations ops = redisTemplate.opsForValue();
        String key = "test";
        ops.set(key, LocalDateTime.now(), 1, TimeUnit.SECONDS);
        Thread.sleep(2 * 100000000000L);
        log.debug("查询值: {}", ops.get(key));
    
    }
}
