package in.hocg.mybatis.web;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IndexControllerTest {
    protected RestTemplate restTemplate = (new TestRestTemplate()).getRestTemplate();
    
    @Test
    public void search() {
        URI uri = uri().resolve("/_search");
        HashMap<String, Object> request = Maps.newHashMap();
        request.put("condition", "444");
        request.put("sort", "{\"key\": \"v\"}");
        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        log.debug("{}", response.getBody());
        Assert.assertEquals("Mock Data", response.getBody());
    }
    
    protected URI uri() {
        return URI.create("http://localhost:8080");
    }
}