package in.hocg.jpa.service;

import in.hocg.jpa.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019-09-21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    
    private final AccountRepository repository;
    
}
