package com.website.company.controller.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.entity.*;
import com.website.company.mapper.ProductMapper;
import com.website.company.service.*;
import com.website.company.utils.ResponseList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 *  产品相关视图
 * @author pengyangyan
 */
@Controller
public class ProductInfoController {
    private static Logger logger = LoggerFactory.getLogger(ProductInfoController.class);

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
    ProductClassService productClassService;
    @Autowired
    HotWordService hotWordService;
    @Resource
    private ProductMapper productMapper;
    @Autowired
    AppService appService;
    @Autowired
    MaisonService maisonService;

    /**
     *  获取产品列表界面
     * @param classId  产品类别id
     * @param keywords 关键词
     * @param model  视图
     * @param request  request
     * @return  产品列表页面
     */
    @GetMapping("/product/list")
    public String productList(@RequestParam(value = "className") Integer classId, @RequestParam(value = "keywords", defaultValue = "") String keywords, Model model, HttpServletRequest request) {
        setLeftMode(model);
//        String requestURI = request.getRequestURI() + "?className=" + classId;
        String requestURI = "/product/list/"+classId+".html";
        Navigation navigation = navigationService.selectByUrl(requestURI);
        //功能分类
        //类别 1-马桶  2-马桶盖
        try {
            ProductClass productClass = productClassService.show(classId);
            List<ProductClass> classList = productClassService.selectList(new EntityWrapper<>());
            if (productClass != null) {
                model.addAttribute("title", navigation.getNavTitle());
                model.addAttribute("keywords", navigation.getNavKeywords());
                model.addAttribute("description", navigation.getNavDesc());
                model.addAttribute("className", productClass.getName());
                model.addAttribute("classList", classList);
                model.addAttribute("productClass", productClass);
                ResponseList<Product> responseList = productService.listByOne(1, 9, keywords, productClass.getName());
                model.addAttribute("responseList", responseList);
                return "showPage/product/product_class";
            }
        } catch (Exception e) {
            return "redirect:/404";
        }
        return "";
    }

     /**
     *  异步获取列表
     * @param param 异步请求的参数
     * @return 返回需要的产品数据
     */
    @PostMapping(value = "/product/ajaxList")
    @ResponseBody
    public ResponseList<Product> ajaxList(@RequestBody Map<String, Object> param) {
        int page = (int) param.get("page");
        int rows = (int) param.get("rows");
        String className = (String) param.get("className");
        return productService.listByOne(page, rows, "", className);
    }

    /**
     * 获取当前产品详细信息界面
     * @param id 产品id
     * @param model 视图
     * @return 当前产品详细信息
     */
    @GetMapping("/product/detail/{id}")
    public String productDetail(@PathVariable(value = "id") Integer id, Model model) {
        setLeftMode(model);
        //类别 1-马桶  0-马桶盖
        Product product = productService.show(id);
        Thread A = new Thread(() -> {
            List<ProductClass> classList = productClassService.selectList(new EntityWrapper<>());
            model.addAttribute("classList", classList);
        });
        Thread B = new Thread(() -> {
            ProductClass productClass = productClassService.selectByName(product.getProductClassName());
            model.addAttribute("productClass", productClass);
            model.addAttribute("className", product.getProductClassName());
            model.addAttribute("product", product);
        });
        Thread C = new Thread(() -> {
            String attribute = product.getAttribute();
            String[] attr = attribute.split(",");
            model.addAttribute("attr", attr);

        });
        Thread D = new Thread(() -> {
            String key = product.getKeywords();
            String[] keywords = key.split("&");
            model.addAttribute("keywords", keywords);
            Set<Product> products = new HashSet<>();
            for (String keyword : keywords) {
                List<Product> products1 = productMapper.getByKeyword(keyword);
                products.addAll(products1);
            }
            List<Product> relativeProduct = new ArrayList<>(products);
            model.addAttribute("relativeProduct", relativeProduct.subList(0, 6));
        });
        A.start();
        B.start();
        C.start();
        D.start();
        try {
            A.join();
            B.join();
            C.join();
            D.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "showPage/product/product_detail";
    }


    /**
     *  获取左侧导航需要的数据
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
}
