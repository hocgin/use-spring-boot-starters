package in.hocg.rabbitmq.mq2;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;

/**
 * Created by hocgin on 2020/7/23.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Configuration
@EnableRabbit
public class RabbitMQConfig {
    
    @Bean
    public RabbitAdmin rabbitAdmin(RabbitTemplate template) {
//        template.setMessageConverter(new Jackson2JsonMessageConverter());
        
        final RabbitAdmin rabbitAdmin = new RabbitAdmin(template);
//        final FanoutExchange exchange = new FanoutExchange("xx", true, false);
//        rabbitAdmin.declareExchange(exchange);
        
        for (Field field : Queues.Fields.class.getFields()) {
            rabbitAdmin.declareQueue(new Queue(field.getName(), true));
        }
        return rabbitAdmin;
    }
    
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(RabbitTemplate template) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(template.getConnectionFactory());
        factory.setMessageConverter(new AutoMessageConverter());
        return factory;
    }
}
