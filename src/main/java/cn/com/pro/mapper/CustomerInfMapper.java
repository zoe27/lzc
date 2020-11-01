package cn.com.pro.mapper;

import cn.com.pro.vo.CustomerInf;
import java.util.List;

public interface CustomerInfMapper {
    int deleteByPrimaryKey(Integer customerInfId);

    int insert(CustomerInf record);

    CustomerInf selectByPrimaryKey(Integer customerInfId);

    List<CustomerInf> selectAll();

    int updateByPrimaryKey(CustomerInf record);
}