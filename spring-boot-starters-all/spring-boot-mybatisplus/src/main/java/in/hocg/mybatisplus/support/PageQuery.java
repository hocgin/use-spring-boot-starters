package in.hocg.mybatisplus.support;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

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
    
    
    @JsonIgnore
    public Page<R> page() {
        return new Page<>(page, limit);
    }
    
    @JsonIgnore
    public QueryWrapper wrapper() {
        QueryWrapper wrapper = new QueryWrapper<>();
        Map<String, String> sortMap = getSortMap();
        if (sortMap.isEmpty()) {
            return wrapper;
        }
        sortMap.keySet().forEach(key -> {
            Optional.ofNullable(sortMap.get(key))
                    .ifPresent(value ->
                            wrapper.orderBy(true,
                                    "ASC".equalsIgnoreCase(value),
                                    CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, key)));
        });
        return wrapper;
    }
}
