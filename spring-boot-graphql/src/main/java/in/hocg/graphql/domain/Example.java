package in.hocg.graphql.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author hocgin
 * @date 2019/7/20
 */
@Data
@Accessors(chain = true)
public class Example {
    private Long id;
    private String title;
}
