package in.hocg.activiti.task;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created by hocgin on 2019/4/10.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
public class HandlerErrorJavaDelegate implements JavaDelegate {
    
    
    @Override
    public void execute(DelegateExecution execution) {
        log.debug("处理信号消息");
    }
}
