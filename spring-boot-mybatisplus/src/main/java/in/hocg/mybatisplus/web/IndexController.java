package in.hocg.mybatisplus.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import in.hocg.mybatisplus.module.service.ExampleService;
import in.hocg.mybatisplus.pojo.ro.ExampleSearchRo;
import in.hocg.mybatisplus.pojo.vo.ExampleVo;
import in.hocg.mybatisplus.support.PageQuery;
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
@AllArgsConstructor
public class IndexController {
    private final ExampleService service;
    
    
    @PostMapping("_search")
    public ResponseEntity search(@Valid @RequestBody PageQuery<ExampleSearchRo, ExampleVo> query) {
        Page<ExampleVo> result = service.pageQuery(query);
        return ResponseEntity.ok().body(result);
    }
}
