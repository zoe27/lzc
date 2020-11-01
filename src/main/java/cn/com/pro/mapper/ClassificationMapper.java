package cn.com.pro.mapper;

import cn.com.pro.vo.Classification;
import java.util.List;

public interface ClassificationMapper {
    int insert(Classification record);

    List<Classification> selectAll();
}