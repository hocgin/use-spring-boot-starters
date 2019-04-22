package in.hocg.elasticsearch.repository;

import in.hocg.elasticsearch.document.Example;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by hocgin on 2019/3/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleRepositoryTest {
    
    @Autowired
    private ExampleRepository exampleRepository;
    
    @Test
    public void index() {
        Example entity = new Example();
        entity.setId(12L);
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setDeletedAt(LocalDateTime.now());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setText("hellox world");
        exampleRepository.index(entity);
    }
    
    @Test
    public void findAll() {
        Iterable<Example> all = exampleRepository.findAll();
        System.out.println(all);
    }
    
    @Test
    public void findAllPage() {
        PageRequest pageable = PageRequest.of(0, 2);
        Page<Example> result = exampleRepository.findAll(pageable);
        Assert.notEmpty(result.getContent(), "The result must not be empty");
    }
    
    @Test
    public void findByText() {
        Optional<Example> result = exampleRepository.findByText("hellox world");
        Assert.isTrue(result.isPresent(), "The result must not be null");
    }
    
    @Test
    public void findAllUseQuery() {
        List<Example> result = exampleRepository.findAllUseQuery();
        Assert.notEmpty(result, "The result must not be empty");
    }
    
    @Test
    public void findAllUseQueryPage() {
        PageRequest pageable = PageRequest.of(0, 2);
        Page<Example> result = exampleRepository.findAllUseQueryPage("55", pageable);
        Assert.isTrue(result.getTotalElements() == 0, "The result size must is 0");
    }
    
    @Test
    public void custom() {
        
        // builder下有must、should以及mustNot 相当于sql中的and、or以及not
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.prefixQuery("text", "hell"));
        
        FieldSortBuilder sortBuilder = SortBuilders.fieldSort("id")
                .order(SortOrder.DESC);
        
        PageRequest pageable = PageRequest.of(0, 2);
    
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withSort(sortBuilder)
                .withPageable(pageable)
                .build();
    
        Page<Example> result = exampleRepository.search(searchQuery);
        
        Assert.notEmpty(result.getContent(), "The result must not empty");
    }
}