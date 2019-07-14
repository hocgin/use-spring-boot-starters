package in.hocg.mybatis.module.mapper;

import in.hocg.mybatis.module.domain.Example;
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
        Optional<Example> first = mapper.findFirst();
        log.debug("执行结果: {}", first);
    }
    
    @Test
    public void insertOne() {
        Example example = new Example();
        example.setId(100L);
        int x = mapper.insertOne(example);
        System.out.println(x);
    }
    
    @Test
    public void insertOneTest() {
        Example example = new Example();
        example.setId(100L);
        mapper.insertOneTest(example);
    }
    
}