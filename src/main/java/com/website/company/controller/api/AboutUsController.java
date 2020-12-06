package com.website.company.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.*;
import com.website.company.service.*;
import com.website.company.utils.ResponseList;
import com.website.company.utils.entityVO.PatentInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 *  关于我们相关视图
 * @author pengyangyan
 */
@Controller
public class AboutUsController {

    private static Logger logger = LoggerFactory.getLogger(AboutUsController.class);

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
    PatentInfoService patentInfoService;
    @Autowired
    AppService appService;
    @Autowired
    MaisonService maisonService;

    /**
     *  获取关于我们的界面
     * @param model 视图
     * @param request request
     * @return  返回关于我们的界面
     * @throws InterruptedException
     */
    @GetMapping("/about")
    String about(Model model, HttpServletRequest request) throws InterruptedException {
        setLeftMode(model);
        String requestURI = request.getRequestURI()+".html";
        Navigation navigation = navigationService.selectByUrl(requestURI);
        model.addAttribute("title", navigation.getNavTitle());
        model.addAttribute("keywords", navigation.getNavKeywords());
        model.addAttribute("description", navigation.getNavDesc());
        Thread t1 = new Thread(() -> {
            CompanyInfo companyInfo = companyInfoService.getCompanyDetail();
            model.addAttribute("companyInfo", companyInfo);
        });
        Thread t2 = new Thread(() -> {
            PatentInfoVO patentInfoVO = patentInfoService.getPatentInfo();

            //证书信息
            model.addAttribute("patentInfo", patentInfoVO);
        });
        Thread t3 = new Thread(() -> {
            //证书遍历数
            model.addAttribute("patentCount", patentInfoService.PatentCount());
        });
        Thread t4 = new Thread(() -> {
            //智能马桶 马桶盖
            model.addAttribute("navMatong", navigationService.selectById(2));
            model.addAttribute("navMatonggai", navigationService.selectById(3));
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        return "showPage/aboutme/aboutme";
    }

    /**
     *  返回 手机端证书界面
     * @param model 视图
     * @return 手机端证书界面
     */
    @RequestMapping("/patentList")
    String getPatentList(Model model) {
        headAndFooter(model);
        List<PatentInfo> patentInfos = patentInfoService.selectList(new EntityWrapper<PatentInfo>());
        model.addAttribute("patentInfos", patentInfos);
        return "showPage/aboutme/patentinfo";
    }

    /**
     *  异步返回证书详情
     * @param param 异步请求参数
     * @return 证书详情
     */
    @PostMapping("/patentAjax")
    @ResponseBody
    PatentInfoVO getPatentInfo(@RequestBody Map<String, Object> param) {
        Integer id = Integer.parseInt((String) param.get("id"));
        Integer key = Integer.parseInt((String) param.get("key"));
        PatentInfoVO patentInfoVO = patentInfoService.ajaxGetPatentInfo(id, key);
        return patentInfoVO;
    }


    /**
     *  左侧导航信息
     * @param model 视图
     */
    private void setLeftMode(Model model) {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            List<Navigation> navVOS = navigationService.showAllNav();
            model.addAttribute("navList", navVOS);
        });
        Thread t2 = new Thread(() -> {
            //联系方式
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("linkUs", userService.show(companyDetail.getLinkManId()));
        });
        Thread t3 = new Thread(() -> {
            //最新资讯
            long s1 = System.currentTimeMillis();
            model.addAttribute("news", newsService.leftNews());
            logger.info("left:" + (System.currentTimeMillis() - s1));
        });
        Thread t4 = new Thread(() -> {
            //热搜词
            List<HotWord> list=hotWordService.getHot(6);
            model.addAttribute("hotWords",list);
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
        System.out.println("消耗时间----->：" + (end - start));
    }

    /**
     * 头部导航和底部需要信息
     * @param model 视图
     */
    private void headAndFooter(Model model) {
        Thread t1 = new Thread(() -> {
            List<Navigation> navVOS = navigationService.showAllNav();
            model.addAttribute("navList", navVOS);
        });
        Thread t2 = new Thread(() -> {
            //联系方式
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("linkUs", userService.show(companyDetail.getLinkManId()));
        });
        Thread t3 = new Thread(()->{
            //店铺
            List<Maison> list =  maisonService.selectList(new EntityWrapper<>());
            model.addAttribute("shop",list);
        });
        Thread t4 = new Thread(() -> {
            //热搜词
            ResponseList<HotWord> hotWordResponseList = hotWordService.list(1, 6);
            model.addAttribute("hotWords", hotWordResponseList.getResult());
        });
        Thread t5 = new Thread(() -> {
            //询盘信息
            int count = messageService.selectCount(new EntityWrapper<Message>().eq("status", 0));
            model.addAttribute("messageCount", count);
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
