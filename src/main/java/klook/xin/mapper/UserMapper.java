package klook.xin.mapper;

import klook.xin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mogo on 2017/7/13 0013.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user_info where id = #{userId}")
    User findUserByUserid(@Param("userId") String userId);

    @Select("select * from user_info")
    List<User> findUser();
}
