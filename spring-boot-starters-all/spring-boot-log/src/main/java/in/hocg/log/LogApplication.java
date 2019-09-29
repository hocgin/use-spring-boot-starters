package in.hocg.log;

import in.hocg.jlog.JLog;
import in.hocg.log.util.RequestKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hocgin on 2019/4/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@SpringBootApplication
@RestController
public class LogApplication {
    
    public static void main(String[] args) {
        JLog.init();
        JLog.d("日志信息");
        SpringApplication.run(LogApplication.class, args);
    }
    
    @RequestMapping("worked")
    public ResponseEntity<String> worked() {
        HttpServletRequest request = RequestKit.get();
        JLog.i("日志信息 IP: %s, User-Agent: %s, AJAX 请求方式: %s", RequestKit.getClientIP(request),
                RequestKit.getUserAgent(request),
                Boolean.toString(RequestKit.isAjax(request)));
        return ResponseEntity.ok("请求成功");
    }
    
}
