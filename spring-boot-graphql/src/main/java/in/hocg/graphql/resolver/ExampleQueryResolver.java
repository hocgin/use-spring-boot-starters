package in.hocg.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import in.hocg.graphql.domain.Example;
import in.hocg.graphql.publisher.ExamplePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author hocgin
 * @date 2019/7/20
 */
@Component
@RequiredArgsConstructor
public class ExampleQueryResolver implements GraphQLQueryResolver {
    
    private final ExamplePublisher publisher;
    
    public List<Example> findAll() {
        Example example = new Example();
        example.setId(1L).setTitle("title");
        
        
        return Arrays.asList(example);
    }
}
