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
public class ScriptTaskTests {
    
    @Autowired
    private RuntimeService runtimeService;
    
    @Test
    public void script_task() {
        // 成功
        // 指定执行的脚本，并设定执行后的返回值
        // <scriptTask activiti:exclusive="true" activiti:resultVariable="ret" id="_2" name="脚本任务" scriptFormat="javascript">
        //      <script><![CDATA[1+1]]></script>
        // </scriptTask>
        ProcessInstance simpleProcess = runtimeService.startProcessInstanceByKey("script_task");
        log.debug("调用结束: {}", simpleProcess);
    }
    
    
}
