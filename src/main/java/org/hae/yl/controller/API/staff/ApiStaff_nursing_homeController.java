package org.hae.yl.controller.API.staff;

import com.github.pagehelper.PageInfo;
import org.hae.yl.entity.Nursing_home;
import org.hae.yl.facade.Nursing_HomeFacade;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class ApiStaff_nursing_homeController {
    @Resource
    private Nursing_HomeFacade facade;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/query")
    public List<Nursing_home> queryAll() {
        return facade.queryAll();
    }

    /**
     * 模糊查询
     * @param like
     * @return
     */
    @GetMapping("/querylike")
    public List<Nursing_home> queryLike(String like) {
        return facade.queryByLike(like);
    }

    /**
     * 分页查询接口
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public PageInfo<Nursing_home> list(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        return facade.queryByPage(pageNum, pageSize);
    }
}
