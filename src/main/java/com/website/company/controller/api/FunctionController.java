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

    //移动端功能介绍页面
    @GetMapping("/functionMoblie")
    String functionMoblie(Model model){
        headerAndFooter(model);
        ResponseList<FunctionClass> response= functionClassService.listFunction(1,5,0);
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
        ResponseList<FunctionClass> response= functionClassService.listFunction(1,5,1);
        model.addAttribute("functionClassList",response);
        return "showPage/function/functionClass";
    }

    //功能列表页面
    @RequestMapping("/function/ClassList")
    String functionClassList(Model model,Integer functionClassId) throws InterruptedException {
        setLeftMode(model);
        Thread t1 = new Thread(()->{
            ResponseList<FunctionClass> response= functionClassService.listFunction(1,5,1);
            model.addAttribute("functionClassList",response);//功能列表
        });
        Thread t2 = new Thread(()->{
            ResponseList<Product> responseList = productService.listByFunction(1,9,"",functionClassId);
            model.addAttribute("responseList",responseList);//该功能的产品
        });
        Thread t3 = new Thread(()->{
            FunctionClass functionClass=functionClassService.showFunction(functionClassId);
            model.addAttribute("functionClass",functionClass);//选中的功能
        });
        switch (functionClassId){
            case 1:
                model.addAttribute("functionKeywords","尿液检测智能马桶，尿液检测智能马桶盖，尿液检测智能座便器");
                model.addAttribute("functionTitle","尿检产品_重庆恭逸科技有限公司");
                model.addAttribute("functionDescription","本页面综合了重庆恭逸科技有限公司尿检产品，包含尿液检测智能马桶，尿液检测智能马桶盖，尿液检测智能座便器。");
                break;
            case 2:
                model.addAttribute("functionKeywords","大便检测智能马桶，大便检测智能马桶盖，大便检测智能座便器");
                model.addAttribute("functionTitle","便检产品_重庆恭逸科技有限公司");
                model.addAttribute("functionDescription","本页面综合了重庆恭逸科技有限公司便检产品，包含大便检测智能马桶，大便检测智能马桶盖，大便检测智能座便器。");
                break;
            case 3:
                model.addAttribute("functionKeywords","体脂检测智能马桶，体脂检测智能马桶盖，体脂检测智能座便器");
                model.addAttribute("functionTitle","体脂产品_重庆恭逸科技有限公司");
                model.addAttribute("functionDescription","本页面综合了重庆恭逸科技有限公司体脂检测产品，包含体脂检测智能马桶，体脂检测智能马桶盖，体脂检测智能座便器。");
                break;
            case 4:
                model.addAttribute("functionKeywords","体脂检测2.0智能马桶，体脂检测2.0智能马桶盖，体脂检测2.0智能座便器");
                model.addAttribute("functionTitle","体脂检测2.0 _重庆恭逸科技有限公司");
                model.addAttribute("functionDescription","本页面综合了重庆恭逸科技有限公司体脂检测2.0产品，包含体脂检测2.0智能马桶，体脂检测2.0智能马桶盖，体脂检测2.0智能座便器。");
                break;
            case 5:
                model.addAttribute("functionKeywords","智能按摩马桶，智能按摩马桶盖，智能按摩座便器");
                model.addAttribute("functionTitle","按摩产品_重庆恭逸科技有限公司");
                model.addAttribute("functionDescription","本页面综合了重庆恭逸科技有限公司按摩产品，包含智能按摩马桶，智能按摩马桶盖，智能按摩座便器。");
                break;

        }
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        return "showPage/function/function_detail";
    }

    //功能分类 ----end

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
    }

    private void headerAndFooter(Model model){
        Thread t1 = new Thread(()->{
            List<Navigation> navVOS = navigationService.showAllNav();
            model.addAttribute("navList",navVOS);
        });
        Thread t2 = new Thread(()->{
            //联系方式
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("linkUs",userService.show(companyDetail.getLinkManId()));
        });
        Thread t4 = new Thread(()->{
            //热搜词
            ResponseList<HotWord> hotWordResponseList=hotWordService.list(1,6);
            model.addAttribute("hotWords",hotWordResponseList.getResult());
        });
        Thread t5 = new Thread(()->{
            //询盘信息
            int count = messageService.selectCount(new EntityWrapper<Message>().eq("status", 0));
            model.addAttribute("messageCount",count);
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
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        try {
            t1.join();
            t2.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
