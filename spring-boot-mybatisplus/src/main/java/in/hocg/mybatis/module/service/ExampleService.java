package in.hocg.mybatis.module.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.mybatis.module.domain.Example;
import in.hocg.mybatis.pojo.ro.ExampleSearchRo;
import in.hocg.mybatis.pojo.vo.ExampleVo;
import in.hocg.mybatis.support.PageQuery;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface ExampleService extends IService<Example> {
    
    /**
     * 分页
     * @param query
     * @return
     */
    Page<ExampleVo> pageQuery(PageQuery<ExampleSearchRo, ExampleVo> query);
}
