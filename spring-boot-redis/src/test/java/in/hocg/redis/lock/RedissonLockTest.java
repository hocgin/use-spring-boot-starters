package in.hocg.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
public class RedissonLockTest {
    
    @Autowired
    private RedissonClient redissonClient;
    
    @Test
    public void worked() {
        Assert.assertNotNull("没有配置成功", redissonClient);
    }
    
    @Test
    public void testLock() throws InterruptedException {
        RLock lock = redissonClient.getLock("lock");
        ExecutorService pool = Executors.newFixedThreadPool(6);
    
        Runnable runnable = () -> {
            try {
                if (lock.tryLock(1, TimeUnit.MINUTES)) {
                    log.info("执行业务 {}", Thread.currentThread().getId());
                    Thread.sleep(1 * 1000);
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                log.error("获取锁超时");
            }
        };
        pool.submit(runnable);
        pool.submit(runnable);
        pool.submit(runnable);
        pool.submit(runnable);
        
        Thread.sleep(10000000L);
    }
}
