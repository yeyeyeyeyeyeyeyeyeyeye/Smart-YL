package org.hae.yl.facade;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hae.yl.entity.Service_appointment;
import org.hae.yl.entity.Service_item;
import org.hae.yl.service.Service_appointmentService;
import org.hae.yl.service.Service_itemService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


/**
 * 服务预约系统 Facade 层
 * 负责聚合底层 Service 的业务逻辑
 */
@Component
public class SericeFacade {

    @Resource
    private Service_itemService service_itemService;

    @Resource
    private Service_appointmentService service_appointmentService;

    /**
     * 获取所有可预约服务列表
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 分页后的服务列表
     */
    public PageInfo<Service_item> getAllAvailableServices(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Service_item> list = service_itemService.SelectAll();
        return new PageInfo<>(list);
    }

    /**
     * 获取某个服务详情信息
     * @param id 服务ID
     * @return 服务详情
     */
    public Service_item getServiceDetail(Integer id) {
        return service_itemService.SelectById(id);
    }

    /**
     * 查询 对应用户的预约记录(status 传值（0待处理，1已确认，2已完成，3已取消）)
     */
    public List<Service_appointment> AppointmentRecord(int userId,int ServicesStatus){
        return service_appointmentService.AppointmentRecord(userId,ServicesStatus);
    }

    /**
     * 用户提交服务预约申请
     * @param appointment 预约信息
     */
    public void submitAppointment(Service_appointment appointment) {
        service_appointmentService.Insert(appointment);
    }

    /**
     * 用户取消预约
     * @param id 预约ID
     */
    public void cancelAppointment(Integer id) {
        service_appointmentService.DeleteById(id);
    }

    /**
     * 获取某个预约单的当前状态
     * @param id 预约ID
     * @return 预约信息
     */
    public Service_appointment getAppointmentStatus(Integer id) {
        return service_appointmentService.SelectById(id);
    }

    //    管理员为预约任务分配工作人员(职工)
    public void assignStaffToBooking(int userId,int serviceId,String Datatime,int status ,String note){
        Service_appointment appointment = null;
        appointment.setUser_id(userId);
        appointment.setService_id(serviceId);
        appointment.setAppointment_time(LocalDateTime.parse(Datatime));
        appointment.setStatus(status);
        appointment.setNote(note);

        service_appointmentService.Insert(appointment);
    }
}
