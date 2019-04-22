package in.hocg.activiti.task;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * Created by hocgin on 2019/4/10.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
public class VarBean implements Serializable {
    
    public void worked() {
        log.debug("成功");
    }
}
