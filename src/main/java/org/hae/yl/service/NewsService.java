package org.hae.yl.service;

import org.hae.yl.entity.News;

import java.util.List;

public interface NewsService {

    /**
     * 查询所有
     */
    List<News> SelectAll();

    /**
     * 根据Id查询
     */
    News SelectById(int id);

    /**
     * 模糊查询
     */
    List<News> SelectByLike(String like);

    /**
     *  根据 Id 修改
     */
    void Update(int id, News nursing_home);

    /**
     *  根据 Id 删除
     *  根据 Id 批量删除
     */
    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    /**
     *  增加
     */
    void Insert(News news);
}
