package in.hocg.rocketmq.consumer;

import in.hocg.rocketmq.constant.GroupConstant;
import in.hocg.rocketmq.constant.TopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/3/11.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = TopicConstant.TEST_TOPIC, consumerGroup = GroupConstant.TEST_CONSUMER_GROUP)
public class TestConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("接收到消息 {}", s);
    }
}
