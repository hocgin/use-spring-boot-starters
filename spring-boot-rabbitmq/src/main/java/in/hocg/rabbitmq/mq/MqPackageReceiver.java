package in.hocg.rabbitmq.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Created by hocgin on 2019-09-21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@EnableBinding(MqPackageSink.class)
public class MqPackageReceiver {
    
    @StreamListener(MqPackageSink.MQ_PACKAGE_INPUT)
    public void input(Object payload) {
        log.debug("接收到的消息: {}", payload);
    }
}
