package org.hae.yl.service.Impl;

import org.hae.yl.entity.Discussion;
import org.hae.yl.mapper.DiscussionMapper;
import org.hae.yl.service.DiscussionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class DiscussionServiceImpl implements DiscussionService {

    @Resource
    private DiscussionMapper discussionMapper;

    @Override
    public List<Discussion> SelectAll() {
        return discussionMapper.SelectAll();
    }

    @Override
    public Discussion SelectById(Integer id) {
        return discussionMapper.SelectById(id);
    }

    @Override
    public int IssuesTotal() {
        return discussionMapper.IssuesTotal();
    }

    @Override
    public List<Discussion> CurrentUserIssuesTotal(int id) {
        return Collections.emptyList();
    }

    @Override
    public void Insert(Discussion discussion) {
        discussionMapper.Insert(discussion);
    }

    @Override
    public void Update(int id, Discussion discussion) {
        discussionMapper.Update(id, discussion);
    }

    @Override
    public void DeleteById(int id) {
        discussionMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        discussionMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void createDiscussion(int userId, String title, String content) {
        Discussion discussion = new Discussion();
        discussion.setTitle(title);
        discussion.setContent(content);
        discussion.setCreator_id(userId);
    }
}
