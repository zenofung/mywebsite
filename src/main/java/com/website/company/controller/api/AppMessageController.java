package com.website.company.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.*;
import com.website.company.service.*;
import com.website.company.utils.Code;
import com.website.company.utils.Response;
import com.website.company.utils.ResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  App和留言相关界面
 */
@Controller
public class AppMessageController {

    private static Logger logger = LoggerFactory.getLogger(AppMessageController.class);

    @Autowired
    NavigationService navigationService;
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
     * 获取app界面
     * @param model model
     * @param request request
     * @return app界面及所需数据
     */
    @RequestMapping("/app")
    String app(Model model, HttpServletRequest request){
        setLeftMode(model);
        String requestURI = request.getRequestURI()+".html";
        Navigation navigation = navigationService.selectByUrl(requestURI);
        model.addAttribute("title",navigation.getNavTitle());
        model.addAttribute("keywords",navigation.getNavKeywords());
        model.addAttribute("description",navigation.getNavDesc());
        App app = appService.showApp();
        model.addAttribute("app",app);
        return "showPage/app/app";
    }


    /**
     * 获取在线留言界面
     * @param model model
     * @param request request
     * @return 返回在线留言界面
     */
    @GetMapping("/message")
    String message(Model model,HttpServletRequest request){
        setLeftMode(model);
        String requestURI = request.getRequestURI()+".html";
        Navigation navigation = navigationService.selectByUrl(requestURI);
        model.addAttribute("title",navigation.getNavTitle());
        model.addAttribute("keywords",navigation.getNavKeywords());
        model.addAttribute("description",navigation.getNavDesc());
        return "showPage/message/message";
    }

    /**
     *  获取留言响应
     * @param message 留言实体
     * @return 留言是否成功
     */
    @RequestMapping(value = "/message/add")
    @ResponseBody
    Response<Message> addMessage(@RequestBody Message message) {
        Response<Message> response = new Response<>();
        if(message.getEmail()!=null){
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(message.getEmail());
            if(!matcher.matches()){
                response.setCode(Code.FAILED);
                response.setMsg("邮箱格式不正确");
                response.setResult(message);
                return response;
            }
        }
        if (messageService.addMessage(message) == 1) {
            response.setResult(message);
            response.setCode(Code.SUCCESSED);
            response.setMsg("提交成功");
        } else {
            response.setCode(Code.FAILED);
            response.setMsg("留言失败");
            response.setResult(message);
        }
        return response;
    }

    /**
     *  左侧导航所需数据
     * @param model model
     */
    private void setLeftMode(Model model){
        long start = System.currentTimeMillis();

        CompletableFuture<Void> navList = CompletableFuture.runAsync(() -> {
            List<Navigation> navVOS = navigationService.showAllNav();
            model.addAttribute("navList", navVOS);
        },taskExecutor);
        CompletableFuture<Void> linkUs = CompletableFuture.runAsync(() -> {
            //联系方式
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("linkUs", userService.show(companyDetail.getLinkManId()));
        },taskExecutor);

        CompletableFuture<Void> news = CompletableFuture.runAsync(() -> {
            //最新资讯
            long s1 = System.currentTimeMillis();
            model.addAttribute("news", newsService.leftNews());
        },taskExecutor);
        CompletableFuture<Void> hotWords = CompletableFuture.runAsync(() -> {
            //热搜词
            List<HotWord> list = hotWordService.getHot(6);
            model.addAttribute("hotWords", list);
        },taskExecutor);
        CompletableFuture<Void> messageCount = CompletableFuture.runAsync(() -> {
            //询盘信息
            int count = messageService.getNewMessage();
            model.addAttribute("messageCount", count);
        },taskExecutor);

        CompletableFuture<Void> appImg = CompletableFuture.runAsync(() -> {
            model.addAttribute("appImg", appService.showApp());
        },taskExecutor);

        CompletableFuture<Void> shop = CompletableFuture.runAsync(() -> {
            //店铺
            List<Maison> list = maisonService.selectList(new EntityWrapper<>());
            model.addAttribute("shop", list);
        },taskExecutor);

        try {
            CompletableFuture.allOf(shop,appImg,messageCount,hotWords,news,navList,linkUs).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间----->："+(end-start));
    }

}
