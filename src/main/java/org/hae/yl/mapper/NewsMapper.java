package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.hae.yl.entity.News;
import org.hae.yl.entity.Nursing_home;

import java.util.List;

public interface NewsMapper extends BaseMapper<News> {


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
