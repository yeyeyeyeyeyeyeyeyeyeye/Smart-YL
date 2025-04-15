package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Select;
import org.hae.yl.entity.User;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询全部
     */
    public List<User> SelectAll();

    /**
     * 用户 total
     * SELECT COUNT(*) FROM user;
     */
    public int Usertotal();

    /**
     * 管理员 total
     * SELECT COUNT(*) FROM user where role_id = 2 or role_id  = 3;
     */
    public int Admintotal();

    /**
     * 根据Id 查询
     * @param id
     * @return
     */
    public User selectById(int id);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public User selectByUsername(String username);

    /**
     * 根据 Id 修改
     */
    public void Update(int id,User user);

    /**
     * 根据 Id 删除
     */
    public void Delete(int id);

    /**
     * 根据 Id 批量删除
     */
    public void DeleteBybatch(List<Integer> ids);

    /**
     * 添加
     */
    public void Insert(User user);

}
