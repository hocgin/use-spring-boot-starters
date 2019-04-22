package in.hocg.activiti.task;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 2019/4/10.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Component("testService")
public class TestService implements JavaDelegate {
    
    public void worked() {
        log.debug("TestService 成功");
    }
    
    @Override
    public void execute(DelegateExecution execution) {
        log.debug("成功[JavaDelegate]");
    }
}
