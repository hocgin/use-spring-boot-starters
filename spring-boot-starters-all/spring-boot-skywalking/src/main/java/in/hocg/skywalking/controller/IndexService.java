package in.hocg.skywalking.controller;

import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/3/24.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
public class IndexService {
    
    public String index() {
        return "worked";
    }
}
