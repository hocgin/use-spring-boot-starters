package in.hocg.mybatis.base.provider;

import lombok.Data;

import java.lang.reflect.Method;

/**
 * Created by hocgin on 2019/7/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class BaseProvider {
    
    public BaseProvider(Class<?> mapperClass, Class<?> entityClass, Method method) {
        System.out.println();
    }
    
    public String empty() {
        return "";
    }
}
