package in.hocg.rabbitmq;

import in.hocg.rabbitmq.mq.MqPackageSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
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
    
    @GetMapping("worked")
    public ResponseEntity<String> worked() {
        boolean send = mqPackageSource.output()
                .send(MessageBuilder.withPayload(1).build());
        return ResponseEntity.ok(String.valueOf(send));
    }
}
