package in.hocg.mybatisplus.pojo.ro;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class ExampleSearchRo {
    @NotBlank(message = "不能为空")
    private String param;
}
