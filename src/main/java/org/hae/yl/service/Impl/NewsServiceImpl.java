package org.hae.yl.service.Impl;

import org.hae.yl.entity.News;
import org.hae.yl.mapper.NewsMapper;
import org.hae.yl.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public List<News> SelectAll() {
        return newsMapper.SelectAll();
    }

    @Override
    public News SelectById(int id) {
        return newsMapper.SelectById(id);
    }

    @Override
    public List<News> SelectByLike(String like) {
        return newsMapper.SelectByLike(like);
    }

    @Override
    public void Update(int id, News nursing_home) {
        newsMapper.Update(id, nursing_home);
    }

    @Override
    public void DeleteById(int id) {
        newsMapper.DeleteById(id);
    }

    @Override
    public void DeleteByIdbatch(List<Integer> ids) {
        newsMapper.DeleteByIdbatch(ids);
    }

    @Override
    public void Insert(News news) {
        newsMapper.Insert(news);
    }
}
