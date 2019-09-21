package in.hocg.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by hocgin on 2019/4/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EnableJpaAuditing
@SpringBootApplication
public class JpaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
    
}
