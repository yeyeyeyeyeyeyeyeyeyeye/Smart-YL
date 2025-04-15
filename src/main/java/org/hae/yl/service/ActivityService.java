package org.hae.yl.service;

import org.hae.yl.entity.Activity;

import java.util.List;

public interface ActivityService {

    /**
     * 查询所有
     */
    List<Activity> SelectAll();

    /**
     * 根据Id查询
     */
    Activity SelectById(int id);

    /**
     * 模糊查询
     */
    List<Activity> SelectByLike(String like);

    /**
     *  根据 Id 修改
     */
    void Update(int id, Activity activity);

    /**
     *  根据 Id 删除
     *  根据 Id 批量删除
     */
    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    /**
     *  增加
     */
    void Insert(Activity activity);
}
