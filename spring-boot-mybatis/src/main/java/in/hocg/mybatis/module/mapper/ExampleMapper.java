package in.hocg.mybatis.module.mapper;

import in.hocg.mybatis.base.InsertOneMapper;
import in.hocg.mybatis.module.domain.Example;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface ExampleMapper extends InsertOneMapper {
    
    
    /**
     * 查找一条数据
     * - 测试 MyBatis 新特性，Optional 返回值
     *
     * @return
     */
    Optional<Example> findFirst();
    

}
