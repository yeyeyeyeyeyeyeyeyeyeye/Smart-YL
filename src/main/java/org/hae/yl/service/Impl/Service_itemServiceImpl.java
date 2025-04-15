package org.hae.yl.service.Impl;

import org.hae.yl.entity.Service_item;
import org.hae.yl.mapper.Service_itemMapper;
import org.hae.yl.service.Service_itemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class Service_itemServiceImpl implements Service_itemService {

    @Resource
    private Service_itemMapper service_itemMapper;


    @Override
    public List<Service_item> SelectAll() {
        return service_itemMapper.SelectAll();
    }

    @Override
    public Service_item SelectById(Integer id) {
        return service_itemMapper.SelectById(id);
    }

    @Override
    public List<Service_item> SelectByLike(Service_item service_item) {
        return service_itemMapper.SelectByLike(service_item);
    }

    @Override
    public void UpdateById(Service_item service_item) {
        service_itemMapper.UpdateById(service_item);
    }

    @Override
    public void DeleteById(Integer id) {
        service_itemMapper.DeleteById(id);
    }

    @Override
    public void DeleteBybatch(List<Integer> ids) {
        service_itemMapper.DeleteBybatch(ids);
    }

    @Override
    public void Insert(Service_item service_item) {
        service_itemMapper.Insert(service_item);
    }
}
