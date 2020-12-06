package com.website.company.service;

import com.website.company.entity.News;
import com.baomidou.mybatisplus.service.IService;
import com.website.company.utils.ResponseList;
import com.website.company.utils.entityVO.NewsVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface NewsService extends IService<News> {

    //新增新闻
    void add(News news);

    //修改新闻
    void update(News news);

    //删除新闻
    void delete(Integer[] ids);

    //查看新闻
    NewsVO show(Integer id);

    //自定义查询新闻
    News selectNewsById(Integer newsId);

    //新闻详情页面 相关新闻
    List<NewsVO> newsvoListNotInNewsId(Integer newsId, String[] key);

    //列表
    ResponseList<News> list(Integer page, Integer rows, String keywords, Integer newsClassId);

    /**
     * 左侧新闻资讯加载 6条
     *
     * @return
     */
    List<News> leftNews();

    /**
     * 主页新闻模块
     *
     * @param classId
     * @param num     获取条数
     * @return
     */
    List<News> indexNews(Integer classId, Integer num);

    //更新新闻访问数
    void updateVisitNum(Map<Integer, Integer> param);

    //置顶操作
    void updateTop(Integer id, Integer top);

    /**
     * 所有新闻，rss获取
     *
     * @return
     */
    List<News> allNews();

    //关键词查询
    List<News> getByKeyword(String keyword);

    Integer selectCountByKeyWord(String keyword);

    /**
     * 关键词分页查询
     * @param page
     * @param row
     * @param keyword
     * @return
     */
    ResponseList<News> getPageKeywordNews(Integer page,Integer row,String keyword);

    /**
     * 新闻资讯第一页加载
     *
     * @param num 获取条数
     * @return
     */
    List<News> getNewsList(Integer num);

    //下一条
    News getNextNews(News news);

    //上一条
    News getPreNews(News news);


    /**
     * 自定义分页查找
     *
     * @param page
     * @param rows
     * @param newsClassId
     * @return List<News>
     */
     List<News> pageNewsList2(Integer page, Integer rows, Integer newsClassId);

}
