package in.hocg.mybatisplus.module.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.mybatisplus.module.domain.Example;
import in.hocg.mybatisplus.module.mapper.ExampleMapper;
import in.hocg.mybatisplus.module.service.ExampleService;
import in.hocg.mybatisplus.pojo.ro.ExampleSearchRo;
import in.hocg.mybatisplus.pojo.vo.ExampleVo;
import in.hocg.mybatisplus.support.PageQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
public class ExampleServiceImpl extends ServiceImpl<ExampleMapper, Example>
        implements ExampleService {
    
    @Override
    public List<Example> list() {
        LambdaQueryChainWrapper<Example> queryWrapper = lambdaQuery();
        return baseMapper.selectList(queryWrapper);
    }
    
    @Override
    public Page<ExampleVo> pageQuery(PageQuery<ExampleSearchRo, ExampleVo> query) {
        Page<ExampleVo> page = query.page();
        QueryWrapper wrapper = query.wrapper();
        return baseMapper.pageQuery(page, wrapper);
    }
}
