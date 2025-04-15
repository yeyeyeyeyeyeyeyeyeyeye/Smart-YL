package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hae.yl.entity.Comment;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> SelectAll();

    List<Comment> SelectByTheme(int id);

    List<Integer> SelectByThemeReturnIds(int id);

    void Insert(Comment discussion);

    void Update(int id, Comment discussion);

    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);
}
