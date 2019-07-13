package in.hocg.mybatis.module.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import in.hocg.mybatis.module.domain.Example;
import in.hocg.mybatis.pojo.vo.ExampleVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleMapperTest {
    @Autowired
    ExampleMapper mapper;
    
    @Test
    public void page() {
        IPage<Example> result = mapper.selectPage(new Page<>(), new QueryWrapper<>());
        System.out.println(result);
    }
    
    @Test
    public void page1() {
        Page<ExampleVo> result = mapper.page1(new Page<>());
        System.out.println(result);
    }
    
    @Test
    public void page2() {
        Page<ExampleVo> result = mapper.page2(new Page<>());
        System.out.println(result);
    }
    
    @Test
    public void findFirst() {
        Optional<Example> result = mapper.findFirst();
        System.out.println(result);
    }
}