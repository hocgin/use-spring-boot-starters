package in.hocg.activiti;

import in.hocg.activiti.task.VarBean;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTaskTests {
    
    @Autowired
    private RuntimeService runtimeService;
    
    @Test
    public void serviceTask__class() {
        
        // 成功
        // 使用类
        // activiti:class="in.hocg.activiti.task.TestService"
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByKey("service_task__class");
        log.debug("调用结束: {}", simpleProcess);
    }
    
    @Test
    public void serviceTask__springbean() {
    
        // 成功
        // 填充 spring bean 的 JavaDelegate
        // activiti:expression="${testVar.worked()}"
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByKey("service_task__springbean");
        log.debug("调用结束: {}", simpleProcess);
    }
    
    @Test
    public void serviceTask__expression() {
    
        // 成功
        // 调用变量的函数
        // activiti:expression="${testVar.worked()}"
        Map<String, Object> vars = new HashMap<>();
        vars.put("testVar", new VarBean());
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByKey("service_task__expression", vars);
        log.debug("调用结束: {}", simpleProcess);
    }
    
    @Test
    public void serviceTask__expression_springbean() {
        
        // 成功
        // 调用 Spring Bean 的函数
        // activiti:expression="${testService.worked()}"
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByKey("service_task__expression_springbean");
        log.debug("调用结束: {}", simpleProcess);
    }
    
}
