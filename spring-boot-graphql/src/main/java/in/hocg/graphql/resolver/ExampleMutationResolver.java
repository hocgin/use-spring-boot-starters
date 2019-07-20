package in.hocg.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import in.hocg.graphql.domain.Example;
import org.springframework.stereotype.Component;

/**
 * @author hocgin
 * @date 2019/7/20
 */
@Component
public class ExampleMutationResolver implements GraphQLMutationResolver {
    
    public Example addExample(String title) {
        return new Example().setTitle(title);
    }
}
