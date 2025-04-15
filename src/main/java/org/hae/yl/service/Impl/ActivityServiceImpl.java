package org.hae.yl.service.Impl;

import org.hae.yl.entity.Activity;
import org.hae.yl.mapper.ActivityMapper;
import org.hae.yl.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> SelectAll() {
        return activityMapper.SelectAll();
    }

    @Override
    public Activity SelectById(int id) {
        return activityMapper.SelectById(id);
    }

    @Override
    public List<Activity> SelectByLike(String like) {
        return activityMapper.SelectByLike(like);
    }

    @Override
    public void Update(int id, Activity activity) {
        activityMapper.Update(id ,activity);
    }

    @Override
    public void DeleteById(int id) {
        activityMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        activityMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void Insert(Activity activity) {
        activityMapper.Insert(activity);
    }
}
