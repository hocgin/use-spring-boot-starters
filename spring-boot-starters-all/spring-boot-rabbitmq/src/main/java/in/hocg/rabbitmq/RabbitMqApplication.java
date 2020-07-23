package in.hocg.rabbitmq;

import in.hocg.rabbitmq.mq.MqPackageSink;
import in.hocg.rabbitmq.mq2.Queues;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2019/4/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@EnableRabbit
@SpringBootApplication
@RestController
public class RabbitMqApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
    }
    
    @Autowired
    private MqPackageSink mqPackageSource;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @GetMapping("worked")
    public ResponseEntity<String> worked() {
        boolean send = mqPackageSource.output().send(MessageBuilder.withPayload(1).build());
        
        final Message message = org.springframework.amqp.core.MessageBuilder.withBody("xxx".getBytes())
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .build();
        rabbitTemplate.convertAndSend(Queues.Fields.TEST234567, message);
        return ResponseEntity.ok(String.valueOf(send));
    }
    
    @RabbitListener(queues = Queues.Fields.TEST234567)
    public void process(@Payload String str) {
        log.info("XXX {}", str);
    }
    
    
    @RabbitListener(queues = Queues.Fields.TEST234567)
    public void process2(@Payload String str) {
        log.info("XXX22 {}", str);
    }
    
}
