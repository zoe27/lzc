package cn.com.pro.mapper;

import cn.com.pro.vo.CustomerAddr;
import java.util.List;

public interface CustomerAddrMapper {
    int deleteByPrimaryKey(Integer customerAddrId);

    int insert(CustomerAddr record);

    CustomerAddr selectByPrimaryKey(Integer customerAddrId);

    List<CustomerAddr> selectAll();

    int updateByPrimaryKey(CustomerAddr record);
}