package cn.com.pro.mapper;

import cn.com.pro.vo.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    List<Product> selectAll();
    //
    void descPro();

    /**
     * 查询结果
     * @param pageable
     * @return
     */
    List<Product> findNew(Pageable pageable);
}