package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hae.yl.entity.Service_appointment;

import java.util.List;

@Mapper
public interface Service_appointmentMapper extends BaseMapper<Service_appointment> {

    /**
     * 查询所有
     */
    List<Service_appointment> SelectAll();

    /**
     * 查询 对应用户的预约记录
     */
    List<Service_appointment> AppointmentRecord(int userId,int ServicesStatus);

    /**
     * 查询最受欢迎服务排行（按预约次数降序）
     * @return
     */
    List<Service_appointment> GetpH();

    /**
     * 根据Id查询
     */
    Service_appointment SelectById(int id);

    /**
     * 根据 Id 修改
     */
    void Update(int id, Service_appointment service_appointment);

    /**
     * 根据 Id 删除
     * 根据 Id 批量删除
     */
    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    /**
     * 增加
     */
    void Insert(Service_appointment service_appointment);
}