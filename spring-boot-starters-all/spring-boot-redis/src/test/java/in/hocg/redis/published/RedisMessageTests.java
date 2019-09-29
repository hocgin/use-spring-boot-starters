package in.hocg.redis.published;

import in.hocg.redis.listener.SubscriberMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hocgin on 2019/4/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisMessageTests {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void published() throws InterruptedException {
        redisTemplate.convertAndSend(SubscriberMessageListener.TOPIC, "this is a message");
        
        Thread.sleep(10000L);
    }
}
