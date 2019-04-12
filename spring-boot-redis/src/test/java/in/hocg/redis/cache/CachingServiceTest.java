package in.hocg.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/4/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CachingServiceTest {
    
    @Autowired
    private CachingService cachingService;
    
    /**
     * 读取缓存
     * @throws InterruptedException
     */
    @Test
    public void readCache() throws InterruptedException {
        LocalDateTime first = cachingService.readCache();
        log.debug("第一次读取: {}", first);
        Thread.sleep(1 * 1000);
        LocalDateTime second = cachingService.readCache();
        log.debug("1s后读取: {}", second);
        
        Assert.assertEquals("没有从缓存中读取", first.toString(), second.toString());
    }
    
    /**
     * 更新缓存
     */
    @Test
    public void updateCache() {
        LocalDateTime first = cachingService.readCache();
        log.debug("第一次读取: {}", first);
        LocalDateTime second = cachingService.updateCache();
        log.debug("更新: {}", second);
        LocalDateTime third = cachingService.readCache();
        log.debug("更新后读取: {}", third);
    
        Assert.assertNotEquals("没有更新缓存", first.toString(), third.toString());
    }
    
    
    /**
     * 删除缓存
     */
    @Test
    public void deleteCache() {
        LocalDateTime first = cachingService.readCache();
        log.debug("第一次读取: {}", first);
        cachingService.deleteCache();
        LocalDateTime third = cachingService.readCache();
        log.debug("删除后重新读取: {}", third);
    
        Assert.assertNotEquals("没有清除成功", first.toString(), third.toString());
    }
}