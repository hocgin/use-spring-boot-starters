package in.hocg.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hocgin
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActivitiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }
    
}
