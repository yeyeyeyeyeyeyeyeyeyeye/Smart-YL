package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hae.yl.entity.Activity_enroll;

import java.util.List;

@Mapper
public interface Activity_enrollMapper extends BaseMapper<Activity_enroll> {

    /**
     * 查询所有
     */
    List<Activity_enroll> SelectAll();

    /**
     * 查询所有自己记录
     */
    List<Activity_enroll> MySelectAll(int user_id);

    /**
     * 根据Id查询
     */
    Activity_enroll SelectById(int id);

    /**
     * 根据 Id 修改
     */
    void Update(int id, Activity_enroll activity_enroll);

    /**
     * 根据 Id 删除
     * 根据 Id 批量删除
     */
    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    /**
     * 增加
     */
    void Insert(Activity_enroll activity_enroll);
}