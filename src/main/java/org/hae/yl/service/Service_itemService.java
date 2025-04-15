package org.hae.yl.service;

import org.hae.yl.entity.Service_item;

import java.util.List;

public interface Service_itemService {

    //查询全部
    List<Service_item> SelectAll();

    //根据 ID 查询
    Service_item SelectById(Integer id);

    //模糊查询
    List<Service_item> SelectByLike(Service_item service_item);

    //根据 ID 修改
    void UpdateById(Service_item service_item);

    //根据 ID 删除
    void DeleteById(Integer id);

    //根据 ID 批量删除
    void DeleteBybatch(List<Integer> ids);

    //添加
    void Insert(Service_item service_item);
}
