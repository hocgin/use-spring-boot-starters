package in.hocg.jpa.repository;

import in.hocg.javers.domain.Account;
import in.hocg.javers.domain.Book;
import in.hocg.javers.repository.AccountRepository;
import in.hocg.javers.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hocgin on 2019-09-21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void insert() throws InterruptedException {
        Account account = new Account();
        account.setName(String.format("hocgin %s", System.currentTimeMillis()));
        accountRepository.save(account);

        Thread.sleep(1000);
        account.setName(String.format("hocgin %s", System.currentTimeMillis()));
        accountRepository.save(account);
        Book book = new Book();
        book.setAuthorId(account.getId());
        book.setTitle("This is a book");
        bookRepository.save(book);
    }
}