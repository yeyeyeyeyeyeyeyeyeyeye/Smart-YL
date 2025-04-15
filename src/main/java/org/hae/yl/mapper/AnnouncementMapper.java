package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hae.yl.entity.Announcement;

import java.util.List;

@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    /**
     * 查询所有
     */
    List<Announcement> SelectAll();

    /**
     * 根据Id查询
     */
    Announcement SelectById(int id);

    /**
     * 模糊查询
     */
    List<Announcement> SelectByLike(String like);

    /**
     * 根据 Id 修改
     */
    void Update(int id, Announcement announcement);

    /**
     * 根据 Id 删除
     * 根据 Id 批量删除
     */
    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    /**
     * 增加
     */
    void Insert(Announcement announcement);
}