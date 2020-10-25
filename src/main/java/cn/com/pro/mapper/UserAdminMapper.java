package cn.com.pro.mapper;

import cn.com.pro.vo.UserAdmin;
import java.util.List;

public interface UserAdminMapper {
    int insert(UserAdmin record);

    List<UserAdmin> selectAll();
}