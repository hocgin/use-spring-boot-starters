package in.hocg.skywalking.service;

import in.hocg.skywalking.controller.IndexService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2019/3/24.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RestController
@AllArgsConstructor
public class IndexController {
    
    private final IndexService indexService;
    
    @Trace
    @GetMapping("/worked")
    public ResponseEntity ok() {
        ActiveSpan.tag("test,call", "这是测试信息");
        log.debug("Debug Info {}", indexService.index());
        return ResponseEntity.ok("Ok" + TraceContext.traceId());
    }
}
