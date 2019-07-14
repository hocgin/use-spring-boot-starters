package in.hocg.mybatis.module.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@ToString
@Data
public class Example {
    private Long id;
    private LocalDateTime created_at;
}
