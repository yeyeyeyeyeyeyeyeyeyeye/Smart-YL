package org.hae.yl.facade;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hae.yl.entity.Message_board;
import org.hae.yl.entity.News;
import org.hae.yl.service.Message_boardService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Component
public class Message_boardFacade {

    @Resource
    private Message_boardService message_boardService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<Message_board> queryByPage(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);  // 启动分页
        List<Message_board> list = message_boardService.SelectAll();  // 原始查询
        return new PageInfo<>(list);  // 包装分页对象返回
    }

    /**
     * 查询所有
     */
    List<Message_board> SelectAll(){
        return message_boardService.SelectAll();
    }

    /**
     * 根据Id查询
     */
    Message_board SelectById(int id){
        return message_boardService.SelectById(id);
    }

    /**
     * 模糊查询
     */
    List<Message_board> SelectByLike(String like){
        return message_boardService.SelectByLike(like);
    }

    /**
     * 根据 Id 修改
     */
    void Update(int id, Message_board message_board){
        message_boardService.Update(id, message_board);
    }

    /**
     * 根据 Id 删除
     * 根据 Id 批量删除
     */
    void DeleteById(int id){
        message_boardService.DeleteById(id);
    }

    void DeleteByIdbatch(List<Integer> ids){
        message_boardService.DeleteByIdbatch(ids);
    }

    /**
     * 增加
     */
    void Insert(Message_board message_board){
        message_boardService.Insert(message_board);
    }

}
