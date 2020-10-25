package cn.com.pro.mapper;

import cn.com.pro.vo.User;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}