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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

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
    @Autowired
    Executor taskExecutor;

    //新闻资讯相关接口 ---- start

    //新闻详情页
    @GetMapping("/newsDetail")
    public String newsDetail(String newsId, String key, Model model) throws IOException, InterruptedException {
        setLeftMode(model);
        long start = System.currentTimeMillis();
        int classId = newsService.show(Integer.parseInt(newsId)).getNewsClassId();

        CompletableFuture<Void> newsClass = runnableExecutor(() -> {
            //新闻分类
            model.addAttribute("newsClass", newsClassService.list());
            logger.info("新闻分类：" + (System.currentTimeMillis() - start));
        });

        CompletableFuture<Void> voidCompletableFuture = runnableExecutor(() -> {
            //上一条下一条
            News newd = newsService.selectNewsById(Integer.parseInt(newsId));
            News news = newsService.getPreNews(newd);
            News news1 = newsService.getNextNews(newd);
            model.addAttribute("newsVOprev", news);
            model.addAttribute("newsVOnext", news1);
            long end = System.currentTimeMillis();
            logger.info("上一条下一条消耗时间:" + (end - start));
        });

        CompletableFuture<Void> voidCompletableFuture1 = runnableExecutor(() -> {
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

        CompletableFuture<Void> newClassDetail = runnableExecutor(() -> {
            //显示所在位置中新闻的所属类别
            model.addAttribute("newClassDetail", newsClassService.show(classId));
            long end = System.currentTimeMillis();
            logger.info("显示所属类别消耗时间:" + (end - start));
        });
        CompletableFuture<Void> aNew = runnableExecutor(() -> {
            //新闻详情
            model.addAttribute("new", newsService.show(Integer.parseInt(newsId)));
            long end = System.currentTimeMillis();
            logger.info("详情消耗时间:" + (end - start));
        });
        try {
            CompletableFuture.allOf(aNew,newClassDetail,newsClass,voidCompletableFuture,voidCompletableFuture1).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "showPage/news/news_detail";
    }

    private CompletableFuture<Void> runnableExecutor(Runnable runnable){
        return CompletableFuture.runAsync(runnable, taskExecutor);
    };

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
        CompletableFuture<Void> voidCompletableFutureNavList = getVoidCompletableFutureNavList(model);
        CompletableFuture<Void> voidCompletableFuture1 = getVoidCompletableFuture1(model);
        CompletableFuture<Void> voidCompletableFuture2 = getVoidCompletableFuture2(model);

        CompletableFuture<Void> voidCompletableFuture = getVoidCompletableFuture(model);
        CompletableFuture<Void> voidCompletableFutureMessage = getVoidCompletableFutureMessage(model);
        CompletableFuture<Void> voidCompletableFutureAppImg = getVoidCompletableFutureAppImg(model);
        CompletableFuture<Void> voidCompletableFutureShop = getVoidCompletableFutureShop(model);
        try {
            CompletableFuture.allOf(voidCompletableFutureNavList,voidCompletableFuture1,voidCompletableFuture2,voidCompletableFuture,voidCompletableFutureMessage,voidCompletableFutureAppImg
            ,voidCompletableFutureShop).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    private CompletableFuture<Void> getVoidCompletableFutureNavList(Model model) {
        return CompletableFuture.runAsync(() -> {
            List<Navigation> navVOS = navigationService.showAllNav();
            model.addAttribute("navList", navVOS);
        }, taskExecutor);
    }

    private CompletableFuture<Void> getVoidCompletableFutureAppImg(Model model) {
        return CompletableFuture.runAsync(() -> {
            model.addAttribute("appImg", appService.showApp());
        }, taskExecutor);
    }

    private CompletableFuture<Void> getVoidCompletableFutureShop(Model model) {
        return CompletableFuture.runAsync(() -> {
            //店铺
            List<Maison> list = maisonService.selectList(new EntityWrapper<>());
            model.addAttribute("shop", list);
        }, taskExecutor);
    }


    private CompletableFuture<Void> getVoidCompletableFutureMessage(Model model) {
        return CompletableFuture.runAsync(() -> {
            //询盘信息
            int count = messageService.getNewMessage();
            model.addAttribute("messageCount", count);
        }, taskExecutor);
    }

    private CompletableFuture<Void> getVoidCompletableFuture2(Model model) {
        return CompletableFuture.runAsync(() -> {
            //最新资讯
            long s1 = System.currentTimeMillis();
            model.addAttribute("news", newsService.leftNews());
            logger.info("left:" + (System.currentTimeMillis() - s1));
        }, taskExecutor);
    }

    private CompletableFuture<Void> getVoidCompletableFuture1(Model model) {
        return CompletableFuture.runAsync(() -> {
            //联系方式
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("linkUs", userService.show(companyDetail.getLinkManId()));
        }, taskExecutor);
    }

    private CompletableFuture<Void> getVoidCompletableFuture(Model model) {
        return CompletableFuture.runAsync(() -> {
            //热搜词
            List<HotWord> list = hotWordService.getHot(6);
            model.addAttribute("hotWords", list);
        }, taskExecutor);
    }

}
