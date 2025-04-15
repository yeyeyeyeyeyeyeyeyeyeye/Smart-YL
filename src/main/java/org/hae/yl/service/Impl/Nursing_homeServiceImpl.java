package org.hae.yl.service.Impl;

import org.hae.yl.entity.Nursing_home;
import org.hae.yl.mapper.Nursing_homeMapper;
import org.hae.yl.service.Nursing_homeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class Nursing_homeServiceImpl implements Nursing_homeService {

    @Resource
    Nursing_homeMapper nursing_homeMapper;

    @Override
    public List<Nursing_home> SelectAll() {
        return nursing_homeMapper.SelectAll();
    }

    @Override
    public Nursing_home SelectById(int id) {
        return nursing_homeMapper.SelectById(id);
    }

    @Override
    public List<Nursing_home> SelectByLike(String like) {
        return nursing_homeMapper.SelectByLike(like);
    }

    @Override
    public void Update(int id, Nursing_home nursing_home) {
        nursing_homeMapper.Update(id,nursing_home);
    }

    @Override
    public void DeleteById(int id) {
        nursing_homeMapper.DeleteById(id);
    }

    @Override
    public void DeleteBybatch(List<Integer> ids) {
        nursing_homeMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void insert(Nursing_home nursing_home) {
        nursing_homeMapper.insert(nursing_home);
    }

    @Override
    public List<Nursing_home> getOrgServiceList(int home_id) {
        return nursing_homeMapper.getOrgServiceList(home_id);
    }

    @Override
    public Nursing_home mapSearchInstitutions(String name) {
        return (Nursing_home) nursing_homeMapper.SelectByLike(name);
    }
}
