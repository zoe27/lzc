package cn.com.pro.mapper;

import cn.com.pro.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}