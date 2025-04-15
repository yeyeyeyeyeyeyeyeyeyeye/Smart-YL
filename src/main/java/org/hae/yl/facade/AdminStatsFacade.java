package org.hae.yl.facade;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hae.yl.entity.*;
import org.hae.yl.service.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统后台管理 Facade 层
 * 负责聚合底层 Service 的业务逻辑
 */
@Component
public class AdminStatsFacade {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private Login_logService login_logService;

    @Resource
    private Service_appointmentService service_appointmentService;

    @Resource
    private Service_itemService service_itemService;

    /**
     * 获取用户列表（带筛选条件）
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @param username 用户名（可选）
     * @param roleId 角色ID（可选）
     * @param status 状态（可选）
     * @return 分页用户列表
     */
    public PageInfo<User> getUserList(int pageNum, int pageSize, String username, Integer roleId, Integer status) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list;

        if (username != null && !username.isEmpty()) {
            // 如果提供了用户名，使用用户名筛选
            list = (List<User>) userService.SelectByUsername(username);
        } else if (roleId != null) {
            // 如果提供了角色ID，使用角色ID筛选
            list = (List<User>) userService.SelectById(roleId);
        } else {
            // 默认获取所有用户
            list = userService.SelectAll();
        }

        // 如果提供了状态，进行状态筛选
        if (status != null) {
            list.removeIf(user -> !user.getStatus().equals(status));
        }

        return new PageInfo<>(list);
    }


    /**
     * 修改用户账号状态
     * @param userId 用户ID
     * @param status 新状态（1-启用，0-禁用）
     * @return 是否成功
     */
    public boolean updateUserStatus(Integer userId, Integer status) {
        User user = userService.SelectById(userId);
        if (user != null) {
            user.setStatus(status);
            userService.Update(userId, user);
            return true;
        }
        return false;
    }

    /**
     * 获取服务统计信息
     * @return 统计信息Map
     */
    public Map<String, Object> getServiceStatistics() {
        Map<String, Object> statistics = new HashMap<>();

        // 获取所有服务
        List<Service_item> allServices = service_itemService.SelectAll();

        // 获取总服务数量
        statistics.put("totalServices", allServices.size());

        // 统计各类型服务数量
        Map<String, Integer> typeCount = new HashMap<>();
        for (Service_item service : allServices) {
            String type = service.getName();
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }
        statistics.put("serviceTypeCount", typeCount);

        return statistics;
    }

    /**
     * 获取预约数据统计
     * @return 统计信息Map
     */
    public Map<String, Object> getAppointmentStatistics() {
        Map<String, Object> statistics = new HashMap<>();

        // 获取所有预约记录
        List<Service_appointment> allAppointments = service_appointmentService.SelectAll();

        // 计算总数
        int total = allAppointments.size();
        statistics.put("totalAppointments", total);

        if (total > 0) {
            // 计算各状态数量
            int completed = 0;
            int cancelled = 0;
            for (Service_appointment appointment : allAppointments) {
                if (appointment.getStatus() == 2) { // 已完成
                    completed++;
                } else if (appointment.getStatus() == 3) { // 已取消
                    cancelled++;
                }
            }

            // 计算成功率
            double successRate = (double) completed / total * 100;
            statistics.put("successRate", String.format("%.2f%%", successRate));

            // 计算取消率
            double cancelRate = (double) cancelled / total * 100;
            statistics.put("cancelRate", String.format("%.2f%%", cancelRate));

            // 添加各状态数量
            statistics.put("completedCount", completed);
            statistics.put("cancelledCount", cancelled);
        } else {
            statistics.put("successRate", "0%");
            statistics.put("cancelRate", "0%");
            statistics.put("completedCount", 0);
            statistics.put("cancelledCount", 0);
        }

        return statistics;
    }

    /**
     * 获取登录日志（分页）
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return 分页登录日志
     */
    public PageInfo<Login_log> queryByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);  // 启动分页
        List<Login_log> list = login_logService.SelectAll();
        return new PageInfo<>(list);  // 包装分页对象返回
    }


}