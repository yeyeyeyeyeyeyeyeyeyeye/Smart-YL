package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.hae.yl.entity.Login_log;
import org.hae.yl.entity.Nursing_home;

import java.util.List;

public interface Login_logMapper extends BaseMapper<Login_log> {

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
