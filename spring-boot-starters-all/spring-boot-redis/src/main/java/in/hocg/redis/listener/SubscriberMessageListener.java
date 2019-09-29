package in.hocg.redis.listener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 2019/4/12.
 * email: hocgin@gmail.com
 * <p>
 * 订阅消息
 *
 * @author hocgin
 */
@Slf4j
@Component
@AllArgsConstructor
public class SubscriberMessageListener implements MessageListener, InitializingBean, DisposableBean {
    
    public static final String TOPIC = "Topic";
    private static final Topic KEYEVENT_EXPIRED_TOPIC = new PatternTopic(TOPIC);
    
    private final RedisMessageListenerContainer listenerContainer;
    
    
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String key = message.toString();
        log.info("[KEY={}] 消息事件", key);
        // .. 进行业务处理
    }
    
    
    @Override
    public void destroy() throws Exception {
        listenerContainer.removeMessageListener(this);
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        listenerContainer.addMessageListener(this, KEYEVENT_EXPIRED_TOPIC);
    }
}
