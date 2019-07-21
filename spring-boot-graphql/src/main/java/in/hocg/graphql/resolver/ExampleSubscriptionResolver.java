package in.hocg.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import in.hocg.graphql.publisher.DataWrapper;
import in.hocg.graphql.publisher.ExamplePublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

/**
 * @author hocgin
 * @date 2019/7/20
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ExampleSubscriptionResolver implements GraphQLSubscriptionResolver {
    
    private final ExamplePublisher examplePublisher;
    
    /**
     * 订阅
     *
     * @return
     */
    public Publisher<DataWrapper> subs(String code) {
        log.debug("code: {}", code);
        return examplePublisher.getPublisher();
    }
}
