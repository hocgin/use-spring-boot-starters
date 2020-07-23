package in.hocg.activiti;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayTests {
    
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    
    
    @Test
    public void event_gateway__message() {
        runtimeService.startProcessInstanceByKey("event_gateway");
        // 成功
        // 事件网关
        // 以消息触发
        List<Execution> list = runtimeService.createExecutionQuery()
                .messageEventSubscriptionName("m2")
                .list();
        for (Execution execution : list) {
            runtimeService.messageEventReceived("m2", execution.getId());
        }
    }
    
    @Test
    public void event_gateway__signal() {
        // 成功
        // 事件网关
        // 以信号触发
        runtimeService.startProcessInstanceByKey("event_gateway");
        List<Execution> list = runtimeService.createExecutionQuery()
                .signalEventSubscriptionName("signala").list();
        for (Execution execution : list) {
            runtimeService.messageEventReceived("signala", execution.getId());
        }
    }
    
    @Test
    public void parallel_gateway() {
        // 成功
        // 并行网关
        runtimeService.startProcessInstanceByKey("parallel_gateway");
    }
    
    @Test
    public void exclusive_gateway() {
        // 成功
        // 单行网关
        runtimeService.startProcessInstanceByKey("exclusive_gateway");
    }
    
    
}
