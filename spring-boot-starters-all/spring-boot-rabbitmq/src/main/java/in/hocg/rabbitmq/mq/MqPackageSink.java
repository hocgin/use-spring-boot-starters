package in.hocg.rabbitmq.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by hocgin on 2019-09-21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface MqPackageSink {
    String MQ_PACKAGE_INPUT = "MQ_PACKAGE_INPUT";
    String MQ_PACKAGE_OUTPUT = "MQ_PACKAGE_OUTPUT";
    
    @Input(MQ_PACKAGE_INPUT)
    SubscribableChannel input();
    
    @Output(MQ_PACKAGE_OUTPUT)
    MessageChannel output();
}
