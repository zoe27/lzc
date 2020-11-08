package cn.com.pro.mapper;

import cn.com.pro.vo.Classification;
import java.util.List;

public interface ClassificationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classification record);

    Classification selectByPrimaryKey(Integer id);

    List<Classification> selectAll();

    int updateByPrimaryKey(Classification record);
}