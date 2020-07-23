package in.hocg.redis.pipelined;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
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
public class RedisPipelinedTests {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    
    /**
     * 测试管道
     */
    @Test
    public void testPipelined() {
        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            for (long i = 0; i < 100000L; i++) {
                connection.set(String.format("pipelined: %d", i).getBytes(), "66".getBytes());
            }
            return null;
        });
        log.debug("{}", "OK");
    }
    
}
