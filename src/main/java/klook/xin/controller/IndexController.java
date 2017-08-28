package klook.xin.controller;

import klook.xin.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by mogo on 2017/7/13 0013.
 */
@RestController
public class IndexController {

    @Autowired
    private RegService mRegService;

    @RequestMapping("/")
    String index() {
        return "Hello World!";
    }

}
