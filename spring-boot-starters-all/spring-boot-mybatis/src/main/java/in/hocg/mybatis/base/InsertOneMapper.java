package in.hocg.mybatis.base;

import in.hocg.mybatis.base.provider.InsertOneProvider;
import in.hocg.mybatis.base.provider.InsertOneTestProvider;
import in.hocg.mybatis.module.domain.Example;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

/**
 * Created by hocgin on 2019/7/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface InsertOneMapper {
    
    /**
     * s
     * @param example
     * @return
     */
    @InsertProvider(type = InsertOneProvider.class, method = InsertOneProvider.METHOD)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertOne(Example example);
    
    
    @InsertProvider(type = InsertOneTestProvider.class, method = "empty")
    void insertOneTest(Example example);
}
