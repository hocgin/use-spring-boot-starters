package in.hocg.redis;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Created by hocgin on 2019/4/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@CacheConfig(cacheNames = "CachingService")
@Service
public class CachingService {
    private static HashMap DATABASE = new HashMap() {{
        put("default", LocalDateTime.now());
    }};
    
    /**
     * 第二次读取会从缓存中读取
     *
     * @return
     */
    @Cacheable
    public LocalDateTime readCache() {
        return LocalDateTime.now();
    }
    
    /**
     * 更新缓存
     *
     * @return
     */
    @CachePut
    public LocalDateTime updateCache() {
        return LocalDateTime.now();
    }
    
    /**
     * 删除缓存
     */
    @CacheEvict
    public void deleteCache() {
    }
}
