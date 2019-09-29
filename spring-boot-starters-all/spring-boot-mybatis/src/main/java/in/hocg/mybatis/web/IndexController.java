package in.hocg.mybatis.web;

import in.hocg.mybatis.module.service.ExampleService;
import in.hocg.mybatis.pojo.ro.ExampleSearchRo;
import in.hocg.mybatis.pojo.vo.ExampleVo;
import in.hocg.mybatis.support.PageQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RequestMapping
@RestController
public class IndexController {
    
    
    @PostMapping("_search")
    public ResponseEntity search(@Valid @RequestBody PageQuery<ExampleSearchRo, ExampleVo> query) {
        return ResponseEntity.ok().body("result");
    }
}
