package org.hae.yl.facade;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hae.yl.entity.Announcement;
import org.hae.yl.entity.Health_record;
import org.hae.yl.service.AnnouncementService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公告与通知模块 Facade 层
 * 负责聚合底层 Service 的业务逻辑
 */
@Component
public class AnnouncementFacade {

    @Resource
    private AnnouncementService announcementService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Announcement> queryByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);  // 启动分页
        List<Announcement> list = announcementService.SelectAll();  // 原始查询
        return new PageInfo<>(list);  // 包装分页对象返回
    }

    /**
     * 发布公告（系统、机构、社区）（管理员权限）
     */
    public void publishNotice(Announcement announcement) {
        announcementService.Insert(announcement);
    };

    /**
     * 根据 Id删除公告
     */
    public void DeleteById(int id){
        announcementService.DeleteById(id);
    }

    /**
     * 根据 Id批量删除公告
     * @param ids
     */
    public void DeleteByIdbatch(List<Integer> ids){
        announcementService.DeleteByIdbatch(ids);
    }

    /**
     * 查询所有
     */
    public List<Announcement> SelectAll(){
        return announcementService.SelectAll();
    }

    /**
     * 根据Id查询
     */
    public Announcement SelectById(int id){
        return announcementService.SelectById(id);
    }

    /**
     * 模糊查询
     */
    public List<Announcement> SelectByLike(String like){
        return announcementService.SelectByLike(like);
    }

    /**
     * 根据 Id 修改
     */
    public void Update(int id, Announcement announcement){
        announcementService.Update(id, announcement);
    }


}
