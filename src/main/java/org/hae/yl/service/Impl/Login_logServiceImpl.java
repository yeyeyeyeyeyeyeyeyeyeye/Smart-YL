package org.hae.yl.service.Impl;

import org.hae.yl.entity.Login_log;
import org.hae.yl.mapper.Login_logMapper;
import org.hae.yl.service.Login_logService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class Login_logServiceImpl implements Login_logService {

    @Resource
    private Login_logMapper login_logMapper;

    @Override
    public List<Login_log> SelectAll() {
        return login_logMapper.SelectAll();
    }

    @Override
    public List<Login_log> SelectUserIdLog(int userId) {
        return login_logMapper.SelectUserIdLog(userId);
    }

    @Override
    public Login_log SelectById(int id) {
        return login_logMapper.SelectById(id);
    }

    @Override
    public void Update(int id, Login_log nursing_home) {
        login_logMapper.Update(id, nursing_home);
    }

    @Override
    public void DeleteById(int id) {
        login_logMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        login_logMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void Insert(Login_log login_log) {
        login_logMapper.Insert(login_log);
    }
}
