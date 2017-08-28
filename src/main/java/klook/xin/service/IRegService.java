package klook.xin.service;


import klook.xin.entity.User;

import java.util.List;

/**
 * Created by mogo on 2017/7/13 0013.
 */
public interface IRegService {
    User select(String id);
    List<User> select();
}
