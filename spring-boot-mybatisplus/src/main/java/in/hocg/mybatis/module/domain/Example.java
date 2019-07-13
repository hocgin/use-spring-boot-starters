package in.hocg.mybatis.module.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@ToString
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_example")
public class Example extends Model<Example> {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
}
