package in.hocg.mybatis.support;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @param <C> 入参
 * @param <R> 出参
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageQuery<C, R> extends AbstractPageQuery {
    @Valid
    protected C condition;
    private Map<String, String> sort = Maps.newHashMap();
    
    
    @Override
    protected Map<String, String> getSortMap() {
        return sort;
    }
    
}
