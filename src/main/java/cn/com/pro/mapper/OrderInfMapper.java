package cn.com.pro.mapper;

import cn.com.pro.vo.OrderInf;
import java.util.List;

public interface OrderInfMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderInf record);

    OrderInf selectByPrimaryKey(Integer orderId);

    List<OrderInf> selectAll();

    int updateByPrimaryKey(OrderInf record);
}