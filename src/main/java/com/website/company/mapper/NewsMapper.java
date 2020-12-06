package com.website.company.mapper;

import com.website.company.entity.News;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.website.company.utils.NewSearchDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
public interface NewsMapper extends BaseMapper<News> {

    //分页查询
    List<News> getNewsLists(@Param("searchDTO") NewSearchDTO newSearchDTO);

    int getNewsCount(@Param("searchDTO") NewSearchDTO newSearchDTO);

    //主页新闻资讯查询
    List<News> getNewsList(@Param("classId") Integer classId);

    //左侧新闻资讯查询
    List<News> getNewsleftList();

    //根据类别获取num条新闻
    List<News> getNewsByClassId(@Param("classId") Integer classId, @Param("num") Integer num);

    //关键词搜索新闻
    List<News> getByKeyword(@Param("keyword") String keyword);

    /**
     * 关键词新闻分页查询 用于搜索界面
     * @param keyword
     * @param pages
     * @param rows
     * @return
     */
    List<News> getByKeywordPage(@Param("keyword") String keyword,@Param("pages") Integer pages, @Param("rows") Integer rows);

    /**
     * 新闻资讯第一页加载
     *
     * @param num 获取条数
     * @return
     */
    List<News> getNewslist(@Param("num") Integer num);

    //新闻子列表下一条
    News getNextNews(@Param("news") News news);

    //新闻子列表上一条
    News getPreNews(@Param("news") News news);

    //新闻资讯下一页
    News getNextNewsAll(@Param("news") News news);

    //新闻资讯上一页
    News getPreNewsAll(@Param("news") News news);

    //自定义查询新闻
    News selectNewsById(@Param("newsId") Integer newsId);

    //分页查询
    List<News> pageList(@Param("pages") Integer pages, @Param("rows") Integer rows);

    //分类分页查询
    List<News> pageListByClassId(@Param("pages") Integer pages, @Param("rows") Integer rows, @Param("classId") Integer classId);

    //相关新闻查询
    List<News> newsvoListNotInNewsId(@Param("newsId") Integer newsId,@Param("keywordss") String[] keywords);

    //新闻关键词搜索数目
    Integer selectCountByKeyWord(@Param("keyword")String keyword);

    List<News> rssNewsAll();
}