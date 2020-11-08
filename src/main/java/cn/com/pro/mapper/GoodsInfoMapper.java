package cn.com.pro.mapper;

import cn.com.pro.vo.GoodsInfo;
import java.util.List;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    List<GoodsInfo> selectAll();

    int updateByPrimaryKey(GoodsInfo record);
}