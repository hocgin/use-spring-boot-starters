package in.hocg.mybatis.module.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import in.hocg.mybatis.module.domain.Example;
import in.hocg.mybatis.pojo.vo.ExampleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface ExampleMapper extends BaseMapper<Example> {
    
    /**
     * 自定义分页
     * - 如果使用 * 号的话
     *
     * @param page
     * @return
     */
    Page<ExampleVo> page1(Page<ExampleVo> page);
    
    /**
     * 自定义分页
     * - 如果仅返回部分属性的话
     *
     * @param objectPage
     * @return
     */
    Page<ExampleVo> page2(Page<Object> objectPage);
    
    /**
     * 查找一条数据
     * - 测试 MyBatis 新特性，Optional 返回值
     *
     * @return
     */
    Optional<Example> findFirst();
    
    /**
     * 完整分页查询
     * @param page
     * @param wrapper
     * @return
     */
    Page<ExampleVo> pageQuery(Page<ExampleVo> page, QueryWrapper wrapper);
}
