package in.hocg.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
	
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		ValueOperations ops = redisTemplate.opsForValue();
		String key = "worked";
		ops.set(key, true);
		
		Assert.assertTrue("不能正常工作", (Boolean) ops.get(key));
	}

}
