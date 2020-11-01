package cn.com.pro.mapper;

import cn.com.pro.vo.Comment;
import java.util.List;

public interface CommentMapper {
    int insert(Comment record);

    List<Comment> selectAll();
}