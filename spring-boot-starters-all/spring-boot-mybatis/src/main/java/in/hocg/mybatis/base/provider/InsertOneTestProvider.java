package in.hocg.mybatis.base.provider;

import org.apache.ibatis.mapping.MappedStatement;

import java.lang.reflect.Method;

/**
 * Created by hocgin on 2019/7/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public class InsertOneTestProvider extends BaseProvider {
    public InsertOneTestProvider(Class<?> mapperClass, Class<?> entityClass, Method method) {
        super(mapperClass, entityClass, method);
    }
    
    public void insertOneTest(MappedStatement statement) {
        System.out.println("");
    }
}
