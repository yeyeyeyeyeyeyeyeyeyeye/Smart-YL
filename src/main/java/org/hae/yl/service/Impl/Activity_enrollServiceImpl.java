package org.hae.yl.service.Impl;

import org.hae.yl.entity.Activity_enroll;
import org.hae.yl.mapper.Activity_enrollMapper;
import org.hae.yl.service.ActivityService;
import org.hae.yl.service.Activity_enrollService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class Activity_enrollServiceImpl implements Activity_enrollService {

    @Resource
    private Activity_enrollMapper activity_enrollMapper;


    @Override
    public List<Activity_enroll> SelectAll() {
        return activity_enrollMapper.SelectAll();
    }

    @Override
    public List<Activity_enroll> MySelectAll(int user_id) {
        return activity_enrollMapper.MySelectAll(user_id);
    }

    @Override
    public Activity_enroll SelectById(int id) {
        return activity_enrollMapper.SelectById(id);
    }

    @Override
    public void Update(int id, Activity_enroll activity_enroll) {
        activity_enrollMapper.Update(id, activity_enroll);
    }

    @Override
    public void DeleteById(int id) {
        activity_enrollMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        activity_enrollMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void Insert(Activity_enroll activity_enroll) {
        activity_enrollMapper.Insert(activity_enroll);
    }
}
