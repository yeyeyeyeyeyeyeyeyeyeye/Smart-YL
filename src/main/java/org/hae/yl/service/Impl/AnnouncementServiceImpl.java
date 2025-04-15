package org.hae.yl.service.Impl;

import org.hae.yl.entity.Announcement;
import org.hae.yl.mapper.AnnouncementMapper;
import org.hae.yl.service.AnnouncementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Resource
    private AnnouncementMapper announcementMapper;


    @Override
    public List<Announcement> SelectAll() {
        return announcementMapper.SelectAll();
    }

    @Override
    public Announcement SelectById(int id) {
        return announcementMapper.SelectById(id);
    }

    @Override
    public List<Announcement> SelectByLike(String like) {
        return announcementMapper.SelectByLike(like);
    }

    @Override
    public void Update(int id, Announcement announcement) {
        announcementMapper.Update(id, announcement);
    }

    @Override
    public void DeleteById(int id) {
        announcementMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        announcementMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void Insert(Announcement announcement) {
        announcementMapper.Insert(announcement);
    }
}
