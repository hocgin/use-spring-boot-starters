package in.hocg.mybatis.base.provider;

import in.hocg.mybatis.module.domain.Example;
import in.hocg.mybatis.util.ReflectionKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hocgin on 2019/7/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
public class InsertOneProvider {
    public final static String METHOD = "insertOne";
    
    
    public String insertOne(Example example) {
        ReflectionKit reflectionKit = ReflectionKit.from(example.getClass());
        List<Field> allField = reflectionKit.getAllField();
        SQL sql = new SQL() {{
            INSERT_INTO("t_example");
            String[] column = allField.stream().map(Field::getName).toArray(String[]::new);
            INTO_COLUMNS(column);
            String[] values = Arrays.stream(column).map((v) -> String.format("#{%s}", v)).toArray(String[]::new);
            INTO_VALUES(values);
        }};
        log.debug("SQL: {}", sql.toString());
        return sql.toString();
    }
}
