package cn.com.pro.mapper;

import cn.com.pro.vo.OrderItem;
import java.util.List;

public interface OrderItemMapper {
    int insert(OrderItem record);

    List<OrderItem> selectAll();
}