package in.hocg.jpa.repository;

import in.hocg.jpa.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hocgin on 2019-09-21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
