package in.hocg.rabbitmq.mq2;

import com.fasterxml.jackson.databind.JavaType;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

/**
 * Created by hocgin on 2020/7/23.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public class AutoMessageConverter extends Jackson2JsonMessageConverter {
    
    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        Object result;
        JavaType targetJavaType = getJavaTypeMapper()
                .toJavaType(message.getMessageProperties());
        if (targetJavaType.getRawClass().isAssignableFrom(String.class)) {
            result = new String(message.getBody());
        } else {
            result = super.fromMessage(message);
        }
        
        System.out.println(targetJavaType);
        return result;
    }
}
