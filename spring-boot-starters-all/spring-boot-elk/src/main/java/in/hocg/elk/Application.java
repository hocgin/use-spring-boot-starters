package in.hocg.elk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hocgin
 */
@RestController
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("worked")
    public void worked() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Application.class);
        while (true) {
            logger.info(String.format("66666666 %s", String.valueOf(System.currentTimeMillis())));
            Thread.sleep(5 * 1000);
        }
    }
    
}
