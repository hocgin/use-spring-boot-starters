package in.hocg.javers.repository;

import in.hocg.javers.domain.Account;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hocgin on 2019-09-21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Repository
@JaversSpringDataAuditable
public interface AccountRepository extends JpaRepository<Account, Long> {
}
