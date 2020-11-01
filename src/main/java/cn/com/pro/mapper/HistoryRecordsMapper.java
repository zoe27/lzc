package cn.com.pro.mapper;

import cn.com.pro.vo.HistoryRecords;
import java.util.List;

public interface HistoryRecordsMapper {
    int insert(HistoryRecords record);

    List<HistoryRecords> selectAll();
}