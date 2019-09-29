package in.hocg.xxljob;

import in.hocg.xxljob.job.TestJob;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author hocgin
 */
@EnableConfigurationProperties
@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class Application {
    private final TestJob testJob;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("worked")
    @ResponseBody
    public Boolean worked() {
        return Objects.isNull(testJob);
    }
    
}
