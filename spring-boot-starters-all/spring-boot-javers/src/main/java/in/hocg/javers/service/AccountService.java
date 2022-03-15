package in.hocg.javers.service;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import in.hocg.javers.domain.Account;
import in.hocg.javers.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

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

    public void create(Long id) {
        Account entity = new Account();
        entity.setId(id);
        entity.setName(RandomUtil.randomString(8));
        repository.save(entity);
    }

    public void rename(Long id, String rename) {
        repository.findById(id).ifPresent(account -> {
            account.setName(rename);
            repository.save(account);
        });
    }

    public void updateSetting(Long id, String setting) {
        repository.findById(id).ifPresent(account -> {
            account.setSettings(setting);
            repository.save(account);
        });
    }

    public Account findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }
}
