package org.hae.yl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.hae.yl.entity.Discussion;
import org.hae.yl.entity.Health_record;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Mapper
public interface DiscussionMapper extends BaseMapper<Discussion> {



    List<Discussion> SelectAll();

    Discussion SelectById(Integer id);

    int IssuesTotal();

    List<Discussion> CurrentUserIssuesTotal(int id);

    void Insert(Discussion discussion);

    void Update(int id, Discussion discussion);

    void DeleteById(int id);

    void DeleteByIdbatch(List<Integer> ids);

}
