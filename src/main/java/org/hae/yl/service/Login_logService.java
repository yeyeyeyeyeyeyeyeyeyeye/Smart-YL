package org.hae.yl.service;

import org.hae.yl.entity.Login_log;

import java.util.List;

public interface Login_logService {

    /**
     * 查询所有
     */
    List<Login_log> SelectAll();

    /**
     * 根据用户名ID查询
     */
    List<Login_log> SelectUserIdLog(int userId);

    /**
     * 根据Id查询
     */
    Login_log SelectById(int id);

    /**
     *  根据 Id 修改
     */
    void Update(int id, Login_log nursing_home);

    /**
     *  根据 Id 删除
     *  根据 Id 批量删除
     */
    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

    /**
     *  增加
     */
    void Insert(Login_log login_log);
}
