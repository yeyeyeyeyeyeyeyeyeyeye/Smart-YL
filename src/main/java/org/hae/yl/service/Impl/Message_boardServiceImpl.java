package org.hae.yl.service.Impl;

import org.hae.yl.entity.Message_board;
import org.hae.yl.mapper.Message_boardMapper;
import org.hae.yl.service.Message_boardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class Message_boardServiceImpl implements Message_boardService {

    @Resource
    private Message_boardMapper message_boardMapper;

    @Override
    public List<Message_board> SelectAll() {
        return message_boardMapper.SelectAll();
    }

    @Override
    public Message_board SelectById(int id) {
        return message_boardMapper.SelectById(id);
    }

    @Override
    public List<Message_board> SelectByLike(String like) {
        return message_boardMapper.SelectByLike(like);
    }

    @Override
    public void Update(int id, Message_board message_board) {
        message_boardMapper.Update(id, message_board);
    }

    @Override
    public void DeleteById(int id) {
        message_boardMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        message_boardMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void Insert(Message_board message_board) {
        message_boardMapper.Insert(message_board);
    }
}
