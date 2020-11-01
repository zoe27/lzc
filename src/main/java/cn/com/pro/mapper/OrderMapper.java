package cn.com.pro.mapper;

import cn.com.pro.vo.Order;
import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    List<Order> selectAll();
}