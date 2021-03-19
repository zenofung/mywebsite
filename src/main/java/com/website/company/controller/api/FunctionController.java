package com.website.company.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.*;
import com.website.company.mapper.FunctionClassMapper;
import com.website.company.service.*;
import com.website.company.utils.ResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Controller
public class FunctionController {

    private static Logger logger = LoggerFactory.getLogger(FunctionController.class);

    @Autowired
    NavigationService navigationService;
    @Autowired
    FunctionClassService functionClassService;
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
    @Resource
    private FunctionClassMapper functionClassMapper;
    @Autowired
    AppService appService;
    @Autowired
    MaisonService maisonService;
    // 功能分类相关接口 ----start
    @Autowired
    Executor taskExecutor;

    //移动端功能介绍页面
    @GetMapping("/functionMoblie")
    String functionMoblie(Model model){
        headerAndFooter(model);
        ResponseList<FunctionClass> response= functionClassService.listFunction(1,4,0);
        model.addAttribute("functionClassList",response);
        return "showPage/function/moreFunction";
    }

    //移动端功能介绍页面显示更多
    @RequestMapping("/functionShowMoreAjax")
    @ResponseBody
    List<FunctionClass> functionShowMore(){
        List<FunctionClass> functionClassList = functionClassMapper.showMoreFunction(0,5,10);
        return functionClassList;
    }

    //功能分类加载
    @GetMapping("/functionClass")
    String functionClassList(Model model, HttpServletRequest request){
        setLeftMode(model);
        String requestURI = request.getRequestURI()+".html";
        Navigation navigation = navigationService.selectByUrl(requestURI);
        model.addAttribute("title",navigation.getNavTitle());
        model.addAttribute("keywords",navigation.getNavKeywords());
        model.addAttribute("description",navigation.getNavDesc());
        ResponseList<FunctionClass> response= functionClassService.listFunction(1,4,0);
        model.addAttribute("functionClassList",response);
        return "showPage/function/functionClass";
    }

    //功能列表页面
    @RequestMapping("/function/ClassList")
    String functionClassList(Model model,Integer functionClassId) {
        setLeftMode(model);

        CompletableFuture<Void> functionClassList = getVoidCompletableFutureFunction(model);
        CompletableFuture<Void> responseList1 = getVoidCompletableFutureResponse(model, functionClassId);
        CompletableFuture<Void> functionClass1 = getVoidCompletableFutureFunction(model, functionClassId);
        try {
            CompletableFuture.allOf(functionClassList,responseList1,functionClass1).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        switch (functionClassId){
            case 1:
                model.addAttribute("functionKeywords","公寓民宅");
                model.addAttribute("functionTitle","隔热保温 防水密封");
                model.addAttribute("functionDescription","延续德式的精工与实用，不论新房装修还是旧房改造，在解决透风渗水炎热寒冷的同时，为您的家居装饰增添更多亮丽色彩。");
                break;
            case 2:
                model.addAttribute("functionKeywords","商业办公");
                model.addAttribute("functionTitle","自由扩展 无限可能");
                model.addAttribute("functionDescription","建筑时光，利用门窗外观极大的可塑性和优异的结构性能，将艺术诠释在建筑外墙上，从而塑造出一个个标志性商业大楼。");
                break;
            case 3:
                model.addAttribute("functionKeywords","私家别墅");
                model.addAttribute("functionTitle","防撬守护 降音降噪");
                model.addAttribute("functionDescription","创意无限，利用更大的造型空间，设计出独特的装饰风格，配置高性能的门窗材料，让空间更加安逸恬静。");
                break;
            case 4:
                model.addAttribute("functionKeywords","公共建筑");
                model.addAttribute("functionTitle","智能开启 净化新风");
                model.addAttribute("functionDescription","融合优秀设计理念，将艺术空间与建筑功能结合，为城市发展提供有价值的产品与服务，打造更具人性化的公共空间。");
                break;
            default: break;

        }
        return "showPage/function/function_detail";
    }


    //功能分类 ----end

    private void setLeftMode(Model model){
        long start = System.currentTimeMillis();

        CompletableFuture<Void> navList = getVoidCompletableFutureNavList(model);

        CompletableFuture<Void> linkUs = getVoidCompletableFuture1(model);

        CompletableFuture<Void> news = getVoidCompletableFuture2(model);
        CompletableFuture<Void> hotWords = getVoidCompletableFuture(model);

        CompletableFuture<Void> messageCount = getVoidCompletableFutureMessage(model);
        CompletableFuture<Void> appImg = getVoidCompletableFutureAppImg(model);
        CompletableFuture<Void> shop = getVoidCompletableFutureShop(model);

        try {
            CompletableFuture.allOf(navList,linkUs,news,hotWords,messageCount,appImg,shop).get();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
    }


    private void headerAndFooter(Model model){
        CompletableFuture<Void> navList = getVoidCompletableFutureNavList(model);
        CompletableFuture<Void> voidCompletableFuture1 = getVoidCompletableFuture1(model);
        CompletableFuture<Void> hotWords = getVoidCompletableFuture(model);

        CompletableFuture<Void> messageCount = getVoidCompletableFutureMessage(model);
        CompletableFuture<Void> appImg = getVoidCompletableFutureAppImg(model);
        CompletableFuture<Void> shop = getVoidCompletableFutureShop(model);
        try {
            CompletableFuture.allOf(navList,voidCompletableFuture1,hotWords,messageCount,appImg,shop).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    private CompletableFuture<Void> getVoidCompletableFutureFunction(Model model, Integer functionClassId) {
        return CompletableFuture.runAsync(() -> {
            FunctionClass functionClass = functionClassService.showFunction(functionClassId);
            model.addAttribute("functionClass", functionClass);//选中的功能
        }, taskExecutor);
    }

    private CompletableFuture<Void> getVoidCompletableFutureResponse(Model model, Integer functionClassId) {
        return CompletableFuture.runAsync(() -> {
            ResponseList<Product> responseList = productService.listByFunction(1, 9, "", functionClassId);
            model.addAttribute("responseList", responseList);//该功能的产品
        }, taskExecutor);
    }

    private CompletableFuture<Void> getVoidCompletableFutureFunction(Model model) {
        return CompletableFuture.runAsync(() -> {
            ResponseList<FunctionClass> response = functionClassService.listFunction(1, 4, 0);
            model.addAttribute("functionClassList", response);//功能列表
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
