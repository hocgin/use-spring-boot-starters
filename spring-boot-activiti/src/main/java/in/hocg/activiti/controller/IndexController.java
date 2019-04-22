package in.hocg.activiti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2019/4/10.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RestController
public class IndexController {
    
    @GetMapping("simple")
    public void simple() {
    
    }
}
