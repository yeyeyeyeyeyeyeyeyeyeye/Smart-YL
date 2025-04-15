package org.hae.yl.service;

import org.apache.ibatis.annotations.Insert;
import org.hae.yl.entity.Discussion;
import org.springframework.stereotype.Component;

import java.util.List;


public interface DiscussionService {

    List<Discussion> SelectAll();

    Discussion SelectById(Integer id);

    /**
     * Issues total
     */
    public int IssuesTotal();

//    /**
//     * Issues 未解决 total
//     */
//    public int IssuesTotalUnsolved();
//
//    /**
//     * Issues 已解决 total
//     */
//    public int IssuesTotalsolved();

    /**
     * 获取当前用户的所有 Issues 记录
     */
    public List<Discussion> CurrentUserIssuesTotal(int id);

    void Insert(Discussion discussion);

    void Update(int id, Discussion discussion);

    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    void createDiscussion(int userId, String title, String content);
}
