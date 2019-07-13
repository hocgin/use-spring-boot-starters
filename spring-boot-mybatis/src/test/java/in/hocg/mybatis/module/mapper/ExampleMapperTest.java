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
        log.debug(" {}", first);
    }
    
    @Test
    public void save() {
        Example example = new Example();
        
    }
    
}