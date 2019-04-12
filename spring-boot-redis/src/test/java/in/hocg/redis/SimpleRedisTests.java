package in.hocg.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.test.context.junit4.SpringRunner;

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
}
