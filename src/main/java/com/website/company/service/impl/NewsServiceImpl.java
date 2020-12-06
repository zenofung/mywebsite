package com.website.company.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.website.company.entity.News;
import com.website.company.mapper.NewsMapper;
import com.website.company.service.NewsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.website.company.utils.Code;
import com.website.company.utils.NewSearchDTO;
import com.website.company.utils.ResponseList;
import com.website.company.utils.entityVO.NewsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.util.StringUtils;

import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Override
    public void add(News news) {
        if(news.getNewsClassId()==null){
            news.setNewsClassId(1);
        }
        if (news.getUpdateDatetime() == null) {
            news.setUpdateDatetime(new Date());
        }
        news.setCreateDatetime(new Date());
        news.setTop(0);
        baseMapper.insert(news);
    }

    @Override
    public void update(News news) {
        if (news.getUpdateDatetime() == null) {
            news.setUpdateDatetime(new Date());
        }
        baseMapper.updateById(news);
    }

    //置顶操作
    @Override
    public void updateTop(Integer id, Integer top) {
        News news = new News();
        news.setId(id);
        news.setTop(top);
        baseMapper.updateById(news);
    }

    @Override
    public void delete(Integer[] ids) {
        baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public NewsVO show(Integer id) {
        News news = baseMapper.selectById(id);
        if (news == null) {
            return null;
        }
        NewsVO newsVO = newsToNewsVO(news);
        return newsVO;
    }

    @Override
    public News selectNewsById(Integer newsId) {
        return baseMapper.selectNewsById(newsId);
    }

    //将news转变为newsVO
    private NewsVO newsToNewsVO(News news) {
        NewsVO newsVO = new NewsVO();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(news.getUpdateDatetime());
        String[] keywords = news.getKeywords().split("&");
        BeanUtils.copyProperties(news, newsVO);
        newsVO.setCreateDate(dateString);
        newsVO.setKeywords(keywords);
        return newsVO;
    }

    @Override
    public List<News> pageNewsList2(Integer page, Integer rows, Integer newsClassId) {
        List<News> newsList = null;
        int pageCur = (page - 1) * rows;
        if (newsClassId != null) {
            newsList = baseMapper.pageListByClassId(pageCur, rows, newsClassId);
        } else {
            newsList = baseMapper.pageList(pageCur, rows);
        }
        return newsList;
    }

    @Override
    public List<NewsVO> newsvoListNotInNewsId(Integer newsId, String[] keywords) {

        List<News> news = baseMapper.newsvoListNotInNewsId(newsId,keywords);
        List<NewsVO> newsVOList = new ArrayList<NewsVO>();
        news.forEach(v -> newsVOList.add(newsToNewsVO(v)));
        return newsVOList;
    }

    @Override
    public ResponseList<News> list(Integer page, Integer rows, String keywords, Integer newsClassId) {
        long start = System.currentTimeMillis();
        NewSearchDTO newSearchDTO = new NewSearchDTO((page - 1) * rows, rows, keywords, newsClassId);
        int count = baseMapper.getNewsCount(newSearchDTO);
        List<News> news = baseMapper.getNewsLists(newSearchDTO);
        ResponseList<News> responses = new ResponseList<>();
        responses.setRows(rows);
        responses.setPage(page);
        responses.setTotal(count);
        responses.setTotalPage(count / rows + 1);
        responses.setResult(news);
        responses.setCode(Code.SUCCESSED);
        responses.setMsg("操作成功");
        long end1 = System.currentTimeMillis();
        System.out.println("ResponseList<News> list消耗时间：" + (end1 - start));
        return responses;
    }

    @Override
    public List<News> leftNews() {
        return baseMapper.getNewsleftList();
    }

    @Override
    public List<News> indexNews(Integer classId, Integer num) {

        return baseMapper.getNewsByClassId(classId, num);
    }

    @Override
    public void updateVisitNum(Map<Integer, Integer> param) {
        for (Integer key : param.keySet()) {
            News news = new News();
            EntityWrapper<News> entityWrapper = new EntityWrapper<>();
            Integer visitNum = baseMapper.selectById(key).getVisitNum();//获取原来数据库中新闻访问数
            entityWrapper.eq("id", key);
            news.setVisitNum(param.get(key) + visitNum);
            baseMapper.update(news, entityWrapper);
        }
    }

    @Override
    public List<News> allNews() {
//        EntityWrapper<News> entityWrapper = new EntityWrapper<>();
//        entityWrapper.orderBy("update_datetime", false);
        return baseMapper.rssNewsAll();
    }

    @Override
    public List<News> getByKeyword(String keyword) {
        return baseMapper.getByKeyword(keyword);
    }

    @Override
    public Integer selectCountByKeyWord(String keyword) {
        return baseMapper.selectCountByKeyWord(keyword);
    }

    @Override
    public ResponseList<News> getPageKeywordNews(Integer page, Integer row, String keyword) {
        Integer pages=(page-1)*row;
        List<News> newsList=baseMapper.getByKeywordPage(keyword,pages,row);
        ResponseList<News> newsResponseList=new ResponseList<>();
        newsResponseList.setResult(newsList);
        newsResponseList.setPage(page);
        newsResponseList.setRows(row);
        newsResponseList.setTotal(newsList.size());
        return newsResponseList;
    }

    @Override
    public List<News> getNewsList(Integer num) {
        return baseMapper.getNewslist(num);
    }

    @Override
    public News getNextNews(News news) {
        News news1 = baseMapper.getNextNews(news);
        if (news1 == null) {
            EntityWrapper<News> entityWrapper = new EntityWrapper<>();
            entityWrapper.eq("news_class_id", news.getNewsClassId());
            entityWrapper.orderBy("update_datetime", false);
            entityWrapper.last("limit 1");
            news1 = baseMapper.selectList(entityWrapper).get(0);
            return news1;
        }
        return news1;
    }

    @Override
    public News getPreNews(News news) {
        News news1 = baseMapper.getPreNews(news);
        if (news1 == null) {
            EntityWrapper<News> entityWrapper = new EntityWrapper<>();
            entityWrapper.eq("news_class_id", news.getNewsClassId());
            entityWrapper.orderBy("update_datetime", true);
            entityWrapper.last("limit 1");
            news1 = baseMapper.selectList(entityWrapper).get(0);
            return news1;
        }
        return news1;
    }



}
