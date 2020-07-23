package in.hocg.elasticsearch.repository;

import in.hocg.elasticsearch.document.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by hocgin on 2019/3/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Repository
public interface ExampleRepository extends ElasticsearchRepository<Example, Long> {
    
    Optional<Example> findByText(String text);
    
    @Query("{\"bool\" : {}}")
    List<Example> findAllUseQuery();
    
    @Query("{\"bool\" : {\"must\": {\"term\": {\"text\": \"?0\"}}}}")
    Page<Example> findAllUseQueryPage(String text, Pageable pageable);
    
    
}
