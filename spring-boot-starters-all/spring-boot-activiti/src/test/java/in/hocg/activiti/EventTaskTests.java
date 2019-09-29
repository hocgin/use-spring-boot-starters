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
public class EventTaskTests {
    
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    
    @Test
    public void timeout_event() throws InterruptedException {
        // 成功
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByKey("timeout_event");
        log.debug("调用结束: {}", simpleProcess);
        
        Thread.sleep(4 * 1000);
        Task result = taskService.createTaskQuery()
                .processInstanceId(simpleProcess.getId())
                .singleResult();
        
        log.debug("{}", result);
    }
    
    @Test
    public void error_event() {
        // 成功
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByKey("error_event");
    }
    
    @Test
    @Deprecated
    public void signal_throw_catch() {
        // 暂未通过
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByKey("signal_throw_catch");
    }
    
    
    @Test
    public void message_start__m1() {
        // 成功
        // 以消息触发开始
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByMessage("m1");
    }
    
    @Test
    public void event_gateway__message() {
        runtimeService.startProcessInstanceByKey("event_gateway");
        // 成功
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
        runtimeService.startProcessInstanceByKey("parallel_gateway");
    }
    
    
}
