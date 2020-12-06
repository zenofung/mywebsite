package com.website.company.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sun.org.apache.bcel.internal.generic.LLOAD;
import com.website.company.entity.*;
import com.website.company.service.*;
import com.website.company.utils.ResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 获取搜索页面
 * @author pengyangyan
 */
@Controller
public class SearchController {

    private static Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    NavigationService navigationService;
    @Autowired
    ProductService productService;
    @Autowired
    MessageService messageService;
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

    /**
     *  获取搜索页面
     * @param keywords 关键词
     * @param model model
     * @return 搜索页面
     */
    @GetMapping("/search")
    String searchByKeywords(@RequestParam("keywords") String keywords, Model model){
        setLeftMode(model);
        model.addAttribute("keywords",keywords);
        //相关产品
        List<Product> productResponseList = productService.getByKeyword(keywords);
        model.addAttribute("productResponseList",productResponseList);
        model.addAttribute("productNum",productResponseList.size());

        //相关新闻
//        List<News> newsResponseList = newsService.getByKeyword(keywords);
//        model.addAttribute("newsList",newsResponseList);

        ResponseList<News> responseList = newsService.getPageKeywordNews(1,10,keywords);
        model.addAttribute("responseList",responseList);
        int newsNum=newsService.selectCountByKeyWord(keywords);
        model.addAttribute("newsNum",newsNum);
        if (productResponseList.size()>0||responseList.getResult().size()>0){
            HotWord hotWord = new HotWord();
            hotWord.setWord(keywords);
            hotWordService.add(hotWord);
        }
        return "showPage/search/relative_search";
    }

    /**
     * 搜索界面新闻异步加载
     * @param param
     * @return
     */
    @PostMapping("/searchNews")
    @ResponseBody
    ResponseList<News> searchNews(@RequestBody Map<String,Object> param){
        String keywords=(String)param.get("keyword");
        Integer rows=(Integer)param.get("rows");
        Integer page=(Integer)param.get("page");
        ResponseList<News> responseList = newsService.getPageKeywordNews(page+1,rows,keywords);
        return responseList;
    }


    /**
     * 左侧导航数据
     * @param  model model
     */
    private void setLeftMode(Model model){
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(()->{
            List<Navigation> navVOS = navigationService.showAllNav();
            model.addAttribute("navList",navVOS);
        });
        Thread t2 = new Thread(()->{
            //联系方式
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("linkUs",userService.show(companyDetail.getLinkManId()));
        });
        Thread t3 = new Thread(()->{
            //最新资讯
            long s1=System.currentTimeMillis();
            model.addAttribute("news",newsService.leftNews());
            logger.info("left:"+(System.currentTimeMillis()-s1));
        });
        Thread t4 = new Thread(()->{
            //热搜词
            List<HotWord> list=hotWordService.getHot(6);
            model.addAttribute("hotWords",list);
        });
        Thread t5 = new Thread(()->{
            //询盘信息
            int count = messageService.getNewMessage();
            model.addAttribute("messageCount", count);
        });
        Thread t6 = new Thread(()->{
            model.addAttribute("appImg",appService.showApp());
        });
        Thread t7 = new Thread(()->{
            //店铺
            List<Maison> list =  maisonService.selectList(new EntityWrapper<>());
            model.addAttribute("shop",list);
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
        logger.info("搜索界面消耗时间----->："+(end-start));
    }
}
