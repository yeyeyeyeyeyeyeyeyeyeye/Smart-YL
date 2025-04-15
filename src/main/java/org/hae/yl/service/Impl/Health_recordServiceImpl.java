package org.hae.yl.service.Impl;

import org.hae.yl.entity.Health_record;
import org.hae.yl.mapper.Health_recordMapper;
import org.hae.yl.service.Health_recordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class Health_recordServiceImpl implements Health_recordService {

    @Resource
    private Health_recordMapper health_recordMapper; ;

    @Override
    public List<Health_record> SelectAll() {
        return health_recordMapper.SelectAll();
    }

    @Override
    public Health_record SelectById(int id) {
        return health_recordMapper.SelectById(id);
    }

    @Override
    public Health_record SelectByIdEndSelection(int id) {
        return health_recordMapper.SelectByIdEndSelection(id);
    }

    @Override
    public List<Health_record> SelectAllSignsData(int id) {
        return health_recordMapper.SelectAllSignsData(id);
    }

    @Override
    public void Update(int id, Health_record health_record) {
        health_recordMapper.Update(id, health_record);
    }

    @Override
    public void DeleteById(int id) {
        health_recordMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        health_recordMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void Insert(Health_record health_record) {
        health_recordMapper.Insert(health_record);
    }
}
