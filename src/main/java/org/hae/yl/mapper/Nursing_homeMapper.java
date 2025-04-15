package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hae.yl.entity.Nursing_home;

import java.util.List;

@Mapper
public interface Nursing_homeMapper extends BaseMapper<Nursing_home> {

    /**
     * 查询所有
     */
    List<Nursing_home> SelectAll();

    /**
     * 根据Id查询
     */
    Nursing_home SelectById(int id);

    /**
     * 地图搜索机构，根据关键词信息模糊查询
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

    void DeleteByIdbatch(List<Integer> ids);

    /**
     *  增加
     */
    void Insert(Nursing_home nursing_home);

    /**
     * 获取某机构下所有服务项目
     * @param home_id
     * @return
     */
    List<Nursing_home> getOrgServiceList(int home_id);

}
