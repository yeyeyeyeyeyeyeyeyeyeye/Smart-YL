package org.hae.yl.service;

import org.hae.yl.entity.Nursing_home;

import java.util.List;

public interface Nursing_homeService {

    /**
     * 查询所有
     */
    List<Nursing_home> SelectAll();

    /**
     * 根据Id查询
     */
    Nursing_home SelectById(int id);

    /**
     * 模糊查询
     */
    List<Nursing_home> SelectByLike(String like);

    /**
     *  根据 Id 修改
     */
    void Update(int id, Nursing_home nursing_home);

    /**
     *  根据 Id 删除
     *  根据 Id 批量删除
     */
    void DeleteById(int id);

    void DeleteBybatch(List<Integer> ids);

    /**
     *  增加
     */
    void insert(Nursing_home nursing_home);

    /**
     *
     * @param home_id
     * @return
     */
    List<Nursing_home> getOrgServiceList(int home_id);

    Nursing_home mapSearchInstitutions(String name);
}
