package in.hocg.mybatisplus.support;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public abstract class AbstractPageQuery implements Serializable {
    protected int limit = 10;
    protected int page = 1;
    
    /**
     * 分页条件
     * @return
     */
    protected abstract Map<String, String> getSortMap();
}
