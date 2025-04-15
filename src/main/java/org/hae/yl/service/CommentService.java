package org.hae.yl.service;

import org.hae.yl.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> SelectAll();

    Comment SelectById(int id);

    List<Comment> SelectByTheme(int id);

    List<Integer> SelectByThemeReturnIds(int id);

    void Insert(Comment content);

    void Update(int id, Comment content);

    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    void addComment(int discussionId, int userId, String content);
}
