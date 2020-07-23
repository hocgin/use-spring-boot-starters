package in.hocg.rabbitmq2;

import cn.hutool.json.JSONUtil;
import in.hocg.rabbitmq2.mq.Queues;
import in.hocg.rabbitmq2.test.XXTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by hocgin on 2019/4/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@SpringBootApplication
@RestController
public class RabbitMqApplication {
    Message buildMessage(Object message) {
        String contentType = null;
        byte[] body = new byte[0];
        if (Objects.isNull(message)) {
            //
        } else if (message instanceof String && JSONUtil.isJson((String) message)) {
            contentType = MessageProperties.CONTENT_TYPE_JSON;
            body = ((String) message).getBytes();
        } else {
            contentType = MessageProperties.CONTENT_TYPE_TEXT_PLAIN;
            body = (String.valueOf(message)).getBytes();
        }
        return org.springframework.amqp.core.MessageBuilder.withBody(body)
                .setContentType(contentType)
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .build();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
    }
    
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @GetMapping("worked")
    public ResponseEntity<String> worked() {
        final XXTest payload = new XXTest();
        payload.setXxx("hocgin");
        rabbitTemplate.convertAndSend(Queues.Fields.TEST, buildMessage(JSONUtil.toJsonStr(payload)));
        
        rabbitTemplate.convertAndSend(Queues.Fields.TEST2, buildMessage(true));
//        rabbitTemplate.convertAndSend(Queues.Fields.TEST2, buildMessage(1.00f));
        rabbitTemplate.convertAndSend(Queues.Fields.TEST2, buildMessage(null));
//        rabbitTemplate.convertAndSend(Queues.Fields.TEST2, buildMessage(1));
        log.info("xxx=>>>>");
        return ResponseEntity.ok("send");
    }
    
    @RabbitListener(queues = Queues.Fields.TEST)
    public void process(@Payload XXTest str) {
        log.info("XXX {}", str);
    }
    
    @RabbitHandler
    @RabbitListener(queues = Queues.Fields.TEST2)
    public void process2(@Payload Boolean str2) {
        log.info("XXX2 {}", str2);
    }
}
