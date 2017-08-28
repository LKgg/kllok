package klook.xin.controller;

import klook.xin.entity.User;
import klook.xin.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by mogo on 2017/7/26 0026.
 * API接口返回Json数据
 */
@RestController
public class APIController {
    @Autowired
    private RegService mRegService;

    @RequestMapping("/getUser")
    User getUser(HttpServletRequest request) {
        return mRegService.select("10");
    }


    @RequestMapping("/getUserList")
    List<User> getUserList() {
        return mRegService.select();
    }

}
