package com.website.company.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.*;
import com.website.company.service.*;
import com.website.company.utils.ResponseList;
import com.website.company.utils.entityVO.NewsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewsInfoController {
    private static Logger logger = LoggerFactory.getLogger(NewsInfoController.class);

    @Autowired
    NavigationService navigationService;
    @Autowired
    MessageService messageService;
    @Autowired
    NewsClassService newsClassService;
    @Autowired
    NewsService newsService;
    @Autowired
    CompanyInfoService companyInfoService;
    @Autowired
    UserService userService;
    @Autowired
    HotWordService hotWordService;
    @Autowired
    AppService appService;
    @Autowired
    MaisonService maisonService;

    //新闻资讯相关接口 ---- start

    //新闻详情页
    @GetMapping("/newsDetail")
    public String newsDetail(String newsId, String key, Model model) throws IOException, InterruptedException {
        setLeftMode(model);
        long start = System.currentTimeMillis();
        int classId = newsService.show(Integer.parseInt(newsId)).getNewsClassId();
        Thread t1 = new Thread(() -> {
            //新闻分类
            model.addAttribute("newsClass", newsClassService.list());
            logger.info("新闻分类："+(System.currentTimeMillis()-start));
        });
        Thread t3 = new Thread(() -> {
            //上一条下一条
            News newd = newsService.selectNewsById(Integer.parseInt(newsId));
            News news = newsService.getPreNews(newd);
            News news1 = newsService.getNextNews(newd);
            model.addAttribute("newsVOprev", news);
            model.addAttribute("newsVOnext", news1);
            long end = System.currentTimeMillis();
            logger.info("上一条下一条消耗时间:" + (end - start));
        });
        Thread t4 = new Thread(() -> {
            //相关新闻
            NewsVO newsVO = newsService.show(Integer.parseInt(newsId));
            String[] keyowrds = newsVO.getKeywords();
            List<NewsVO> newsVOS = newsService.newsvoListNotInNewsId(Integer.parseInt(newsId), keyowrds);
            //移动设备新闻页面相关新闻
            int num = newsVOS.size() / 3 + 1;
            if (num > 4) {
                num = 4;
            }
            List<ResponseList<NewsVO>> responseLists = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                ResponseList<NewsVO> responseList = new ResponseList();
                if (i * 3 > newsVOS.size()) {
                    responseList.setResult(newsVOS.subList((i - 1) * 3, newsVOS.size()));
                } else {
                    responseList.setResult(newsVOS.subList((i - 1) * 3, i * 3));
                }
                responseLists.add(responseList);
                responseList = null;
            }
            model.addAttribute("newsVOxsList", responseLists);
            //pc端新闻页面相关新闻
            List<NewsVO> firstList = null;
            List<NewsVO> secondList = null;
            if (newsVOS.size() > 5) {
                firstList = newsVOS.subList(1, 6);
                if (newsVOS.size() > 10) {
                    secondList = newsVOS.subList(6, 11);
                } else {
                    secondList = newsVOS.subList(6, newsVOS.size());
                }
            } else {
                firstList = newsVOS;
            }
            model.addAttribute("firstList", firstList);
            model.addAttribute("secondList", secondList);
            long end = System.currentTimeMillis();
            logger.info("相关新闻消耗时间:" + (end - start));
        });
        Thread t5 = new Thread(() -> {
            //显示所在位置中新闻的所属类别
            model.addAttribute("newClassDetail", newsClassService.show(classId));
            long end = System.currentTimeMillis();
            logger.info("显示所属类别消耗时间:" + (end - start));
        });
        Thread t6 = new Thread(() -> {
            //新闻详情
            model.addAttribute("new", newsService.show(Integer.parseInt(newsId)));
            long end = System.currentTimeMillis();
            logger.info("详情消耗时间:" + (end - start));
        });
        t1.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t1.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        long end = System.currentTimeMillis();
        logger.info("新闻详情消耗时间:" + (end - start));
        return "showPage/news/news_detail";
    }

//    //新闻列表分页ajax访问
//    @RequestMapping(value = "/newsList")
//    @ResponseBody
//    public Map<String, Object> newsList(@RequestBody Map<String, Object> param) {
//        long start = System.currentTimeMillis();
//        int page = (int) param.get("page");
//        int rows = (int) param.get("rows");
//        String classIdstr = (String) param.get("classId");
//        int classId;
//        List<NewsVO> newsVOList = null;
//        if (classIdstr == null || classIdstr.isEmpty()) {
//            newsVOList = newsService.pageNewsList(page, rows, null);
//        } else {
//            classId = Integer.parseInt(classIdstr);
//            newsVOList = newsService.pageNewsList(page, rows, classId);
//        }
//        Map<String, Object> result = new HashMap<>();
//        long end = System.currentTimeMillis();
//        logger.info("新闻异步消耗时间:" + (end - start));
//        result.put("responselist", newsVOList);
//        return result;
//    }

    //新闻列表分页ajax访问
    @PostMapping(value = "/newsLists")
    @ResponseBody
    public Map<String, Object> newsList2(@RequestBody Map<String, Object> param) {
        long start = System.currentTimeMillis();
        int page = (int) param.get("page");
        int rows = (int) param.get("rows");
        String classIdstr = (String) param.get("classId");
        int classId;
        List<News> newsList = null;
        if (classIdstr == null || classIdstr.isEmpty()) {
            newsList = newsService.pageNewsList2(page, rows, null);
        } else {
            classId = Integer.parseInt(classIdstr);
            newsList = newsService.pageNewsList2(page, rows, classId);
        }
        Map<String, Object> result = new HashMap<>();
        long end = System.currentTimeMillis();
        logger.info("新闻异步消耗时间:" + (end - start));
        result.put("responselists", newsList);
        return result;
    }

    //新闻列表页面加载
    @GetMapping("/newsListPage")
    public String newsListPage(String key, Integer classId, Model model, HttpServletRequest request) {
        long start = System.currentTimeMillis();
        setLeftMode(model);
        logger.info("新闻left加载时间1："+(System.currentTimeMillis()-start));
        //新闻分类
        List<NewsClass> newsClasses=newsClassService.list();
        model.addAttribute("newsClass",newsClasses );
        //页面加载时，分页显示第一页数据
        List<News> newsList = null;
        String page = "showPage/news/news_list";
        if (classId == null) {
            String requestURI = request.getRequestURI()+".html";
            Navigation navigation = navigationService.selectByUrl(requestURI);
            long start2 = System.currentTimeMillis();
            newsList = newsService.getNewsList(10);
            logger.info("列表速度:" + (System.currentTimeMillis() - start2));
            model.addAttribute("newsClassDesc", newsClasses.get(0));
            model.addAttribute("newsList", newsList);
            model.addAttribute("tdk", navigation);
            model.addAttribute("page", newsService.selectCount(new EntityWrapper<>()) / 10 + 1);
            long end = System.currentTimeMillis();
            logger.info("新闻列表加载时间："+(end-start));
            return page;
        } else {
            newsList = newsService.indexNews(classId, 10);
            model.addAttribute("newsList", newsList);
            model.addAttribute("page", newsService.selectCount(new EntityWrapper<News>().eq("news_class_id", classId)) / 10 + 1);
            //用于传给分页按钮的参数
            model.addAttribute("classId", classId);
            newsClasses.forEach(v->{
                if(v.getId().equals(classId)){
                    model.addAttribute("newsClassDesc", v);
                    model.addAttribute("className", v.getNewsClassName());
                    model.addAttribute("newClassDetail", v.getDescription());
                    model.addAttribute("newsClassKeywords", v.getKeywords());
                }
            });

            if (classId == 2) {
                page = "showPage/news/news_questlist";
            } else {
                page = "showPage/news/news_hangyelist";
            }
            long end = System.currentTimeMillis();
            logger.info("新闻列表加载时间："+(end-start));
            return page;
        }

    }

    //新闻列表相关接口 ---- end

    private void setLeftMode(Model model) {
        Thread t1 = new Thread(() -> {
            long s1 = System.currentTimeMillis();
            List<Navigation> navVOS = navigationService.showAllNav();
            model.addAttribute("navList", navVOS);
            logger.info("导航栏加载:" + (System.currentTimeMillis() - s1));
        });
        Thread t2 = new Thread(() -> {
            //联系方式
            long s1 = System.currentTimeMillis();
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("linkUs", userService.show(companyDetail.getLinkManId()));
            logger.info("联系方式:" + (System.currentTimeMillis() - s1));
        });
        Thread t3 = new Thread(() -> {
            //最新资讯
            long s1 = System.currentTimeMillis();
            model.addAttribute("news", newsService.leftNews());
            logger.info("最新资讯:" + (System.currentTimeMillis() - s1));
        });
        Thread t4 = new Thread(() -> {
            //热搜词
            long s1 = System.currentTimeMillis();
            //热搜词
            List<HotWord> list=hotWordService.getHot(6);
            model.addAttribute("hotWords",list);
            logger.info("热搜词:" + (System.currentTimeMillis() - s1));
        });
        Thread t5 = new Thread(() -> {
            //询盘信息
            int count = messageService.getNewMessage();
            model.addAttribute("messageCount", count);
        });
        Thread t6 = new Thread(() -> {
            model.addAttribute("appImg", appService.showApp());
        });
        Thread t7 = new Thread(()->{
            //店铺
            long s1 = System.currentTimeMillis();
            List<Maison> list =  maisonService.selectList(new EntityWrapper<>());
            model.addAttribute("shop",list);
            logger.info("店铺:" + (System.currentTimeMillis() - s1));
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
    }
}
