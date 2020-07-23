package in.hocg.graphql.publisher;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by hocgin on 2019-07-22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Accessors(chain = true)
public class DataWrapper {
    private String data;
}
