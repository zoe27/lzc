package cn.com.pro.mapper;

import cn.com.pro.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();

<<<<<<< HEAD
    User findByUsernameAndPassword(String username, String password);
=======
    /**
     * 查询用户是否存在
     * @param pass
     * @return
     */
    User findByUsernameAndPassword(@Param("name") String userName, @Param("pass") String pass);
>>>>>>> 3581315ef2ac9611563082c937e199024c6db55a
}