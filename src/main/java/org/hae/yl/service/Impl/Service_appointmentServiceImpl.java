package org.hae.yl.service.Impl;

import org.hae.yl.entity.Service_appointment;
import org.hae.yl.mapper.Service_appointmentMapper;
import org.hae.yl.service.Service_appointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class Service_appointmentServiceImpl implements Service_appointmentService {

    @Resource
    private Service_appointmentMapper service_appointmentMapper;

    @Override
    public List<Service_appointment> SelectAll() {
        return service_appointmentMapper.SelectAll();
    }

    @Override
    public List<Service_appointment> AppointmentRecord(int userId, int ServicesStatus) {
        return service_appointmentMapper.AppointmentRecord(userId, ServicesStatus);
    }

    @Override
    public List<Service_appointment> GetpH() {
        return service_appointmentMapper.GetpH();
    }

    @Override
    public Service_appointment SelectById(int id) {
        return service_appointmentMapper.SelectById(id);
    }

    @Override
    public void Update(int id, Service_appointment service_appointment) {
        service_appointmentMapper.Update(id, service_appointment);
    }

    @Override
    public void DeleteById(int id) {
        service_appointmentMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        service_appointmentMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void Insert(Service_appointment service_appointment) {
        service_appointmentMapper.Insert(service_appointment);
    }
}
