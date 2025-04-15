package org.hae.yl.service.Impl;

import org.hae.yl.entity.User;
import org.hae.yl.mapper.UserMapper;
import org.hae.yl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper usermapper;

    @Override
    public List<User> SelectAll() {
        return usermapper.SelectAll();
    }

    @Override
    public int Usertotal() {
        return usermapper.Usertotal();
    }

    @Override
    public int Admintotal() {
        return usermapper.Admintotal();
    }

    @Override
    public User SelectById(int id) {
        return usermapper.selectById(id);
    }

    @Override
    public User SelectByUsername(String username) {
        return usermapper.selectByUsername(username);
    }

    @Override
    public void Update(int id,User user) {
        usermapper.Update(id,user);
    }

    @Override
    public void Delete(int id) {
        usermapper.Delete(id);
    }

    @Override
    public void DeleteBybatch(List<Integer> ids) {
        usermapper.DeleteBybatch(ids);
    }

    @Override
    public void Insert(User user) {
        usermapper.Insert(user);
    }

}
