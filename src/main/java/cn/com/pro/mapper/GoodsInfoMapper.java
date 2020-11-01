package cn.com.pro.mapper;

import cn.com.pro.vo.GoodsInfo;
import java.util.List;

public interface GoodsInfoMapper {
    int insert(GoodsInfo record);

    List<GoodsInfo> selectAll();
}