package in.hocg.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hocgin on 2019/4/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRedisTests {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void testLock() {
    
    }
    
    /**
     * 原子性测试
     * @throws InterruptedException
     */
    @Test
    public void testGetAndAdd() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        RedisAtomicLong atomicLong = new RedisAtomicLong("ATOM_V", redisTemplate.getConnectionFactory());
        atomicLong.set(0);
        
        executorService.submit(() -> {
            for (int i = 0; i < 100; i++) {
                atomicLong.incrementAndGet();
            }
        });
        
        executorService.submit(() -> {
            for (int i = 0; i < 100; i++) {
                atomicLong.incrementAndGet();
            }
        });
        
        executorService.submit(() -> {
            for (int i = 0; i < 100; i++) {
                atomicLong.incrementAndGet();
            }
        });
        
        executorService.submit(() -> {
            for (int i = 0; i < 100; i++) {
                atomicLong.incrementAndGet();
            }
        });
        
        executorService.submit(() -> {
            for (int i = 0; i < 100; i++) {
                atomicLong.incrementAndGet();
            }
        });
        Thread.sleep(5000);
        Assert.assertEquals("原子性失败", atomicLong.get(), 500L);
        
    }
    
    
    /**
     * 排行榜
     */
    @Test
    public void testZSet() {
        String key = "score";
        ZSetOperations ops = redisTemplate.opsForZSet();
        
        // 填充数据
        for (int i = 0; i < 1000; i++) {
            ops.add(key, String.format("名称 %d", i), i * (Math.random() * 10));
        }
        ops.add(key, "hocgin", 66666);
    
        // 排序后获取前10名  [0, 9]
        Set set = ops.reverseRange(key, 0, 9);
        log.info("前10名: {}", set);
        
        // 排序后获取指定信息
        Long rank = ops.reverseRank(key, "hocgin");
        double score = ops.score(key, "hocgin");
        log.info("hocgin 排名: {}, 分数: {}", rank, score);
        
        // 统计
        Long count = ops.count(key, 60, 99);
        log.info("统计 [60, 99] 人数: {}", count);
    }
}
