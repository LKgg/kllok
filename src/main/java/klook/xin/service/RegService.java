package klook.xin.service;

import klook.xin.entity.User;
import klook.xin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mogo on 2017/7/13 0013.
 */
@Service
public class RegService implements IRegService{

    @Autowired(required = false)
    private UserMapper mUserMapper;

    @Override
    public User select(String id) {
        return mUserMapper.findUserByUserid(id);
    }

    @Override
    public List<User> select() {
        return mUserMapper.findUser();
    }
}
