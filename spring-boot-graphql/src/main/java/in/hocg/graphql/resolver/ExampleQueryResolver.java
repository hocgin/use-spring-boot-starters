package in.hocg.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import in.hocg.graphql.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author hocgin
 * @date 2019/7/20
 */
@Component
public class ExampleQueryResolver implements GraphQLQueryResolver {
    
    public List<Example> findAll() {
        Example example = new Example();
        example.setId(1L).setTitle("title");
        return Arrays.asList(example);
    }
}
