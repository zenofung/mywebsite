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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

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
    @Autowired
    Executor taskExecutor;

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

        CompletableFuture<Void> classList1 = runnableExecutor(() -> {
            List<ProductClass> classList = productClassService.selectList(new EntityWrapper<>());
            model.addAttribute("classList", classList);
        });
        CompletableFuture<Void> voidCompletableFuture = runnableExecutor(() -> {
            ProductClass productClass = productClassService.selectByName(product.getProductClassName());
            model.addAttribute("productClass", productClass);
            model.addAttribute("className", product.getProductClassName());
            model.addAttribute("product", product);
        });
        CompletableFuture<Void> attr1 = runnableExecutor(() -> {
            String attribute = product.getAttribute();
            String[] attr = attribute.split(",");
            model.addAttribute("attr", attr);

        });
        CompletableFuture<Void> voidCompletableFuture1 = runnableExecutor(() -> {
            String key = product.getKeywords();
            String[] keywords = key.split("&");
            model.addAttribute("keywords", keywords);
            Set<Product> products = new HashSet<>();
            for (String keyword : keywords) {
                List<Product> products1 = productMapper.getByKeyword(keyword);
                products.addAll(products1);
            }
            List<Product> relativeProduct = new ArrayList<>(products);
            model.addAttribute("relativeProduct", relativeProduct.subList(0, relativeProduct.size()));

        });
        try {
            CompletableFuture.allOf(voidCompletableFuture,voidCompletableFuture1,attr1,classList1).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return "showPage/product/product_detail";
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
