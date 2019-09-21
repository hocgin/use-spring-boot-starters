package in.hocg.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by hocgin on 2019-09-21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Configurable
@Component
public class AccountAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String currentAccount = String.format("hocg.in %d", System.currentTimeMillis());
        log.debug("查找当前用户: {}", currentAccount);
        return Optional.of(currentAccount);
    }
}
