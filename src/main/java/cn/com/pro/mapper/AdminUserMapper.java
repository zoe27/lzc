package cn.com.pro.mapper;

import cn.com.pro.vo.AdminUser;
import java.util.List;

public interface AdminUserMapper {
    int insert(AdminUser record);

    List<AdminUser> selectAll();
}