package org.hae.yl.facade;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hae.yl.entity.Role;
import org.hae.yl.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户角色 Facade 层
 * 负责聚合底层 Service 的业务逻辑
 */
@Controller
public class RoleFacade {

    @Resource
    RoleService roleService;

    /**
     * 角色列表查询
     * @return
     */
    public List<Role> SelectAll(){
        return roleService.SelectAll();
    }

    /**
     * 角色列表分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Role> queryByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);  // 启动分页
        List<Role> list = roleService.SelectAll();  // 原始查询
        return new PageInfo<>(list);  // 包装分页对象返回
    }

    /**
     * 根据 Id 查询 角色对象
     * @param id
     * @return
     */
    public Role SelectById(int id){
        return roleService.SelectById(id);
    }
}
