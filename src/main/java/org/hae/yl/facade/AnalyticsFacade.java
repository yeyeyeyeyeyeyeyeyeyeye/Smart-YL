package org.hae.yl.facade;

import org.hae.yl.entity.Discussion;
import org.hae.yl.entity.Service_appointment;
import org.hae.yl.service.DiscussionService;
import org.hae.yl.service.Service_appointmentService;
import org.hae.yl.service.UserService;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import org.springframework.stereotype.Component;
import oshi.hardware.CentralProcessor;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据统计与分析 Facade 层
 * 负责聚合底层 Service 的业务逻辑
 */
@Component
public class AnalyticsFacade {

    @Resource
    private UserService userService; ;

    @Resource
    private Service_appointmentService service_appointmentService;

    @Resource
    private DiscussionService discussionService;

/**
 * CPU 占用
 */
    public double Cpuinfo() throws InterruptedException {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hal = systemInfo.getHardware();
        CentralProcessor processor = hal.getProcessor();

        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Thread.sleep(1000); // 采样间隔
        long[] ticks = processor.getSystemCpuLoadTicks();

        double cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks);

      //  System.out.printf("CPU 使用率: %.2f%%%n", cpuLoad * 100);
        return cpuLoad;
    }
/**
 * RAM 占用
 */
    public double Raminfo() throws InterruptedException {
        SystemInfo systemInfo = new SystemInfo();
        GlobalMemory memory = systemInfo.getHardware().getMemory();

        long total = memory.getTotal();
        long available = memory.getAvailable();
        long used = total - available;

        double usageRate = (double) used / total * 100;

       // System.out.println("总内存: " + formatBytes(total));
       // System.out.println("已用内存: " + formatBytes(used));
       // System.out.println("可用内存: " + formatBytes(available));
       // System.out.printf("内存使用率: %.2f%%\n", usageRate);
        return usageRate;
    }

/**
 * 用户 total
 * SELECT COUNT(*) FROM user;
 */
    public int User_total(){
        return userService.Usertotal();
    }

/**
 * 管理员 total
 * SELECT COUNT(*) FROM user where role_id = 2 or role_id  = 3;
 */
    public int Admin_total(){
        return userService.Admintotal();
    }

/**
 * 获取最受欢迎的服务排行
 */
    public List<Service_appointment> GetpH(){
        return service_appointmentService.GetpH();
    }


/**
 * Issues total
 */
public int IssuesTotal(){
    return discussionService.IssuesTotal();
}



/**
 * 获取当前用户的所有 Issues 记录
 */
public List<Discussion> CurrentUserIssuesTotal(int id){
    return discussionService.CurrentUserIssuesTotal(id);
}

///**
// * Issues 未解决 total
// */
//
///**
// * Issues 已解决 total
// */
//    需求待定
//    客服/管理员回复留言
//    标记留言已解决
//    获取常见问题 FAQ 列表



}
