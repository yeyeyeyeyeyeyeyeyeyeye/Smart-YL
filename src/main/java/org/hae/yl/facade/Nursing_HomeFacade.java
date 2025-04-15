package org.hae.yl.facade;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hae.yl.entity.Nursing_home;
import org.hae.yl.service.Nursing_homeService;
import org.hae.yl.service.Service_itemService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;


/**
 * 养老机构信息管理 Facade 层
 * 负责聚合底层 Service 的业务逻辑
 */
@Component
public class Nursing_HomeFacade {

    @Resource
    Nursing_homeService nursing_homeService;


    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Nursing_home> queryByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);  // 启动分页
        List<Nursing_home> list = nursing_homeService.SelectAll();  // 原始查询
        return new PageInfo<>(list);  // 包装分页对象返回
    }

    /**
     * 获取单个机构详细信息
     * @param id
     * @return
     */
    public Nursing_home SelectById(int id){
        return nursing_homeService.SelectById(id);
    }

    /**
     * 获取某机构下所有服务项目
     */
    public List<Nursing_home> getOrgServiceList(int home_id){
        return nursing_homeService.getOrgServiceList(home_id);
    }

    /**
     * 地图搜索机构，根据关键词或位置信息查询
     * @param name
     * @return
     */
    public Nursing_home mapSearchInstitutions(String name){
        return nursing_homeService.mapSearchInstitutions(name);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Nursing_home> queryAll() {
        return nursing_homeService.SelectAll();
    }


    /**
     * 模糊查询
     */
    public List<Nursing_home> queryByLike(String like){
        return nursing_homeService.SelectByLike(like);
    }

    /**
     *  根据 Id 修改
     */
    public void Update(int id,Nursing_home nursing_home) {
        nursing_homeService.Update(id,nursing_home);
    }

    /**
     *  根据 Id 删除
     *  根据 Id 批量删除
     */
    public void DeleteById(int id) {
        nursing_homeService.DeleteById(id);
    }

    public void DeleteBybatch(List<Integer> ids) {
        nursing_homeService.DeleteBybatch(ids);
    }

    /**
     *  增加
     */
    public void Insert(Nursing_home nursing_home) {
        nursing_homeService.insert(nursing_home);
    }
}
