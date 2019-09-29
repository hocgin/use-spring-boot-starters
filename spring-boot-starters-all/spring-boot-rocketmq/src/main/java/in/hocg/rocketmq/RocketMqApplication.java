package in.hocg.rocketmq;

import com.alibaba.fastjson.JSONObject;
import in.hocg.rocketmq.constant.TopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
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
@SpringBootApplication
@RestController
public class RocketMqApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RocketMqApplication.class, args);
    }
    
    
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @GetMapping("worked")
    public ResponseEntity<String> worked() {
        Message<Integer> message = MessageBuilder.withPayload(1).build();
        SendResult sendResult = rocketMQTemplate.syncSend(TopicConstant.TEST_TOPIC, message);
        return ResponseEntity.ok(JSONObject.toJSONString(sendResult));
    }
}
