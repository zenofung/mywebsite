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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

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
    @Autowired
    Executor taskExecutor;

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
     *  获取左侧导航需要的数据
     * @param model 视图
     */
    private void setLeftMode(Model model) {
        CompletableFuture<Void> voidCompletableFutureNavList = getVoidCompletableFutureNavList(model);
        CompletableFuture<Void> voidCompletableFuture1 = getVoidCompletableFuture1(model);
        CompletableFuture<Void> voidCompletableFuture2 = getVoidCompletableFuture2(model);
        CompletableFuture<Void> voidCompletableFuture = getVoidCompletableFuture(model);
        CompletableFuture<Void> voidCompletableFutureMessage = getVoidCompletableFutureMessage(model);
        CompletableFuture<Void> voidCompletableFutureAppImg = getVoidCompletableFutureAppImg(model);
        CompletableFuture<Void> voidCompletableFutureShop = getVoidCompletableFutureShop(model);
        try {
            CompletableFuture.allOf(voidCompletableFuture,voidCompletableFuture1,voidCompletableFuture2,voidCompletableFutureNavList,voidCompletableFutureMessage,voidCompletableFutureAppImg,voidCompletableFutureShop).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    private CompletableFuture<Void> runnableExecutor(Runnable runnable){
        return CompletableFuture.runAsync(runnable, taskExecutor);
    };



    private CompletableFuture<Void> getVoidCompletableFutureResponse(Model model, Integer functionClassId) {
        return CompletableFuture.runAsync(() -> {
            ResponseList<Product> responseList = productService.listByFunction(1, 9, "", functionClassId);
            model.addAttribute("responseList", responseList);//该功能的产品
        }, taskExecutor);
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
