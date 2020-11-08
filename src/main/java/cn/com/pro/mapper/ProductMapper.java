package cn.com.pro.mapper;

import cn.com.pro.vo.Product;
import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    List<Product> selectAll();
}