package org.hae.yl.service;

import org.hae.yl.entity.Health_record;

import java.util.List;

public interface Health_recordService {

    /**
     * 查询所有
     */
    List<Health_record> SelectAll();

    /**
     * 根据Id查询
     */
    Health_record SelectById(int id);

    /**
     * 获取用户最近一次健康打卡状态
     * @param id
     * @return
     */
    Health_record SelectByIdEndSelection(int id);

    /**
     * 获取ID用户所以体征数据
     * @param id
     * @return
     */
    List<Health_record> SelectAllSignsData(int id);

    /**
     * 根据 Id 修改
     */
    void Update(int id, Health_record health_record);

    /**
     * 根据 Id 删除
     * 根据 Id 批量删除
     */
    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    /**
     * 增加
     */
    void Insert(Health_record health_record);

}
