package cn.com.pro.mapper;

import cn.com.pro.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();


    /**
     * 查询用户是否存在
     * @param pass
     * @return
     */
    User findByUsernameAndPassword(@Param("name") String userName, @Param("pass") String pass);
}