package in.hocg.redis.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 2019/4/12.
 * email: hocgin@gmail.com
 * <p>
 * Redis Key 过期事件监听器
 *
 * @author hocgin
 */
@Slf4j
@Component
public class IKeyExpirationEventMessageListener extends KeyExpirationEventMessageListener {
    
    public IKeyExpirationEventMessageListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
    
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String key = message.toString();
        log.debug("[KEY={}] 过期事件", key);
        // .. 进行业务处理
    }
}
