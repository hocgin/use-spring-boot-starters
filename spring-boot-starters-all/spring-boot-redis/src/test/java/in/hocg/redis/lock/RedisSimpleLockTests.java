package in.hocg.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class RedisSimpleLockTests {
    @Autowired
    private RedisSimpleLock simpleLock;
    
    /**
     * 简单的锁
     */
    @Test
    public void test() throws InterruptedException {
        String Key = "lock";
        ExecutorService pool = Executors.newFixedThreadPool(2);
    
        simpleLock.unlock(Key);
        pool.submit(() -> {
            if (simpleLock.lock(Key, 3, TimeUnit.MINUTES)) {
                log.debug("执行业务");
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                simpleLock.unlock(Key);
            }
        });
        
        Thread.sleep(1000);
        while (true) {
            boolean lock = simpleLock.lock(Key, 1, TimeUnit.MINUTES);
            log.debug("获取锁结果 {}", lock);
            if (lock) {
                log.debug("获取成功");
                return;
            }
            Thread.sleep(100);
        }
    }
}
