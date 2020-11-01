package cn.com.pro.mapper;

import cn.com.pro.vo.ProductComment;
import java.util.List;

public interface ProductCommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(ProductComment record);

    ProductComment selectByPrimaryKey(Integer commentId);

    List<ProductComment> selectAll();

    int updateByPrimaryKey(ProductComment record);
}