package com.website.company.controller.api;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.rometools.rome.feed.atom.*;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Item;
import com.rometools.rome.feed.synd.SyndPerson;
import com.website.company.entity.*;
import com.website.company.mapper.NewsMapper;
import com.website.company.mapper.ProductMapper;
import com.website.company.service.*;
import com.website.company.utils.NewsClassDTO;
import com.website.company.utils.ProductDTO;
import com.website.company.utils.ResponseList;
import com.website.company.utils.functionClassDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/**
 * @author pengyangyan
 */
@Controller
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    NavigationService navigationService;
    @Autowired
    SpannerService spannerService;
    @Autowired
    FunctionClassService functionClassService;
    @Autowired
    ProductService productService;
    @Autowired
    MessageService messageService;
    @Autowired
    NewsClassService newsClassService;
    @Autowired
    NewsService newsService;
    @Autowired
    CompanyInfoService companyInfoService;
    @Autowired
    LinksService linksService;
    @Autowired
    UserService userService;
    @Autowired
    ProductClassService productClassService;
    @Autowired
    HotWordService hotWordService;
    @Autowired
    AreaPart areaPart;
    @Autowired
    BannerInfoService bannerInfoService;
     @Resource
    private NewsMapper newsMapper;
    @Resource
    private ProductMapper productMapper;
    @Autowired
    AppService appService;
    @Autowired
    MaisonService maisonService;
    @Autowired
    Executor taskExecutor;



    //首页
    @GetMapping("/index")
    public ModelAndView toIndex(){
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/getIndexNews")
    @ResponseBody
    public Map<String,Object> getIndexNews(){
        Map<String,Object> map = new HashMap<>(3);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(2);
            BeanUtils.copyProperties(show, newsClassDTO, "list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            map.put("news1", newsClassDTO);
        }, taskExecutor);

        CompletableFuture<Void> voidCompletableFuture1 = CompletableFuture.runAsync(() -> {
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(1);
            BeanUtils.copyProperties(show, newsClassDTO, "list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            map.put("news2", newsClassDTO);
        }, taskExecutor);

        CompletableFuture<Void> voidCompletableFuture2 = CompletableFuture.runAsync(() -> {
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(3);
            BeanUtils.copyProperties(show, newsClassDTO, "list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            map.put("news3", newsClassDTO);
        }, taskExecutor);

        try {
            CompletableFuture.allOf(voidCompletableFuture,voidCompletableFuture1,voidCompletableFuture2).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return map;
    }

    @GetMapping("/getIndexProducts")
    @ResponseBody
    public Map<String,Object> getIndexProducts(){
        Map<String,Object> map = new HashMap<>(1);
        //产品展示
        List<Product> list = productMapper.getProductList();
        List<ProductDTO> productDTOList = new ArrayList<>();
        int i=4;
        while (i>0){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductList(list.subList((i-1)*3,i*3));
            productDTOList.add(productDTO);
            i--;
        }
        map.put("products",productDTOList);
        return map;
    }

    @GetMapping("/getIndexFunctionAndClass")
    @ResponseBody
    public Map<String,Object> getIndexFunctionAndClass(){
        Map<String,Object> map = new HashMap<>(2);
        CompletableFuture<Void> functions = CompletableFuture.runAsync(() -> {
            ResponseList<FunctionClass> list = functionClassService.listFunction(1, 4, 0);
            map.put("functions", list);
        }, taskExecutor);
        CompletableFuture<Void> classList1 = CompletableFuture.runAsync(() -> {
            List<ProductClass> classList = productClassService.selectProductClassList();
            map.put("classList", classList);
        }, taskExecutor);
        try {
            CompletableFuture.allOf(classList1,functions).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return map;
    }





    @GetMapping("/")
    ModelAndView home(Model model, String area, HttpServletRequest request) throws InterruptedException{
        String requestURI = request.getRequestURI();
        Navigation navigation = navigationService.selectByUrl(requestURI);
        headAndFooter(model);
        if(area!=null){
            String title = navigation.getDivName().replaceAll("<area>", area);
            String description = navigation.getDivDesc().replaceAll("<area>", area);
            model.addAttribute("title",title);
            model.addAttribute("description",description);
        }else{
            model.addAttribute("title",navigation.getNavTitle());
            model.addAttribute("description",navigation.getNavDesc());
        }
        model.addAttribute("keywords",navigation.getNavKeywords());
        CompletableFuture<Void> voidCompletableFuture = runnableExecutor(() -> {
            //banner信息
            List<Spanner> bannerPic = spannerService.list();
            model.addAttribute("bannerPic", bannerPic);
            //公告/活动
            List<BannerInfo> bannerInfos = bannerInfoService.selectBannerList();
            model.addAttribute("bannerInfo", bannerInfos);
        });
        CompletableFuture<Void> products = runnableExecutor(() -> {
            //产品展示
            List<Product> list = productMapper.getProductList();
            List<ProductDTO> productDTOList = new ArrayList<>();
            int size = list.size();
            int i = 1;
            while (i > 0) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductList(list.subList((i - 1) * 3, i * 3));
                productDTOList.add(productDTO);
                if (i * 3 >= size - 2) {
                    break;
                }
                i++;
            }
            model.addAttribute("products", productDTOList);
        });

        CompletableFuture<Void> classList1 = runnableExecutor(() -> {
            List<ProductClass> classList = productClassService.selectProductClassList();
            model.addAttribute("classList", classList);
        });
        CompletableFuture<Void> voidCompletableFuture1 = runnableExecutor(() -> {
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(2);
            BeanUtils.copyProperties(show, newsClassDTO, "list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            model.addAttribute("news1", newsClassDTO);
        });
        CompletableFuture<Void> voidCompletableFuture2 = runnableExecutor(() -> {
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(1);
            BeanUtils.copyProperties(show, newsClassDTO, "list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            model.addAttribute("news2", newsClassDTO);
        });
        CompletableFuture<Void> voidCompletableFuture3 = runnableExecutor(() -> {
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(3);
            BeanUtils.copyProperties(show, newsClassDTO, "list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            model.addAttribute("news3", newsClassDTO);
        });
        CompletableFuture<Void> voidCompletableFuture4 = runnableExecutor(() -> {
            //关于我们
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("companyInfo", companyDetail);
            //友情链接
            model.addAttribute("links", linksService.list());
        });
        CompletableFuture<Void> functions = runnableExecutor(() -> {
            ResponseList<FunctionClass> list = functionClassService.listFunction(1, 4, 0);
            model.addAttribute("functions", list);
        });
        try {
            CompletableFuture.allOf(functions,voidCompletableFuture,voidCompletableFuture1,voidCompletableFuture2,voidCompletableFuture3,voidCompletableFuture4,products,classList1).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return  new ModelAndView("showPage/home/index");
    }


    //rss
    @RequestMapping(path = "/rss.xml")
    @ResponseBody
    public Channel rss() {
        Channel channel = new Channel();
        channel.setEncoding("UTF-8");// RSS文件编码
        channel.setLanguage("ZH_CN");// RSS使用的语言
        channel.setFeedType("rss_2.0");
        channel.setTitle("北京如日之升建筑材料有限公司");
        channel.setDescription("北京如日之升建筑材料是一家致力于智能马桶、智能马桶盖、智能座便器，研发，生产，销售为一体的科技型公司。公司自主研发的智能体脂检测马桶盖，尿检马桶盖，便检马桶盖，智能按摩马桶盖获得20多项专利。");
        channel.setLink("https://www.huochimc.com");
        channel.setUri("https://www.huochimc.com");
        channel.setGenerator("霍驰");
        Date postDate = new Date();
        channel.setPubDate(postDate);
        List<Item> items=new ArrayList<>();
        List<News> newsList=newsService.allNews();
        List<Product> productList=productService.rssProductAll();
        newsList.forEach(v->{
            Item item = new Item();
            item.setTitle(v.getNewsTitle());
            item.setAuthor(v.getAuthor());
            item.setLink("https://www.huochimc.com/newsDetail/newsId"+v.getId()+".html");
            item.setUri("https://www.huochimc.com/newsDetail/newsId"+v.getId()+".html");
            com.rometools.rome.feed.rss.Category category = new com.rometools.rome.feed.rss.Category();
            category.setValue("新闻");
            item.setCategories(Collections.singletonList(category));
           /* Description descr = new Description();
            descr.setValue(v.getDescription());
            item.setDescription(descr);*/
            item.setPubDate(v.getCreateDatetime());
            items.add(item);
        });

        productList.forEach(v->{
            Item item = new Item();
            item.setTitle(v.getProductName());
            item.setAuthor("北京如日之升");
            item.setLink("https://www.huochimc.com/product/detail/"+v.getId()+".html");
            item.setUri("https://www.huochimc.com/product/detail/"+v.getId()+".html");
            com.rometools.rome.feed.rss.Category category = new com.rometools.rome.feed.rss.Category();
            category.setValue("产品");
            item.setCategories(Collections.singletonList(category));
            item.setPubDate(v.getCreateDatetime());
            items.add(item);
        });
        channel.setItems(items);
        return channel;
    }

    //xml
    @GetMapping(path = "/sitemap.xml")
    @ResponseBody
    public Feed atom() {
        Feed feed = new Feed();
        feed.setFeedType("atom_1.0");
        feed.setTitle("北京如日之升建筑材料有限公司");
        feed.setId("https://www.huochimc.com");

        Content subtitle = new Content();
        subtitle.setType("text/plain");
        subtitle.setValue("https://www.huochimc.com");
        feed.setSubtitle(subtitle);
        Date postDate = new Date();
        feed.setUpdated(postDate);

        List<News> newsList=newsService.allNews();
        List<Product> productList=productService.rssProductAll();
        List<Entry> entries=new ArrayList<>();
        newsList.forEach(v->{
            Entry entry = new Entry();
            Link link = new Link();
            link.setHref("https://www.huochimc.com/newsDetail/newsId"+v.getId()+".html.");
            entry.setAlternateLinks(Collections.singletonList(link));
            SyndPerson author = new Person();
            author.setName(v.getAuthor());
            entry.setAuthors(Collections.singletonList(author));
            entry.setCreated(v.getCreateDatetime());
            entry.setPublished(postDate);
            entry.setUpdated(v.getUpdateDatetime());
            entry.setTitle(v.getNewsTitle());

            Category category = new Category();
            category.setTerm("新闻");
            entry.setCategories(Collections.singletonList(category));

//            Content summary = new Content();
//            summary.setType("text/plain");
//            summary.setValue("value");
//            entry.setSummary(summary);
            entries.add(entry);
        });

        productList.forEach(v->{
            Entry entry = new Entry();
            Link link = new Link();
            link.setHref("https://www.huochimc.com/product/detail/"+v.getId()+".html");
            entry.setAlternateLinks(Collections.singletonList(link));
            SyndPerson author = new Person();
            author.setName("如日之升建筑材料");
            entry.setAuthors(Collections.singletonList(author));
            entry.setCreated(v.getCreateDatetime());
            entry.setPublished(postDate);
            entry.setUpdated(v.getUpdateDatetime());
            entry.setTitle(v.getProductName());

            Category category = new Category();
            category.setTerm("产品");
            entry.setCategories(Collections.singletonList(category));

//            Content summary = new Content();
//            summary.setType("text/plain");
//            summary.setValue("value");
//            entry.setSummary(summary);
            entries.add(entry);
        });

        feed.setEntries(entries);
        //参加这里关于不同的新话题
        return feed;
    }

    //爬虫协议
    @GetMapping("/  .txt")
    public void robotsTxt(HttpServletResponse response) throws IOException {
        Writer writer = response.getWriter();
        String lineSeparator = System.getProperty("line.separator", "\n");
        writer.append("User-agent: *").append(lineSeparator);
        writer.append("Allow: ").append("/").append(lineSeparator);
        writer.append("Disallow: ").append("/static/js/").append(lineSeparator);
    }

    //网站地图
    @GetMapping("/sitemap")
    String webMap(Model model,String moblie) throws InterruptedException {
        long start=System.currentTimeMillis();
        if(moblie!=null){
            model.addAttribute("moblie",1);
        }else{
            model.addAttribute("moblie",2);
        }
        CompletableFuture<Void> voidCompletableFuture = runnableExecutor(() -> {
            long tt1 = System.currentTimeMillis();
            List<NewsClassDTO> newsClassDTOS = new ArrayList<>();
            List<NewsClass> newsClasses = newsClassService.list();
            newsClasses.forEach(v -> {
                NewsClassDTO newsClassDTO = new NewsClassDTO();
                BeanUtils.copyProperties(v, newsClassDTO, "list");
                newsClassDTO.setList(newsService.indexNews(v.getId(), 6));
                newsClassDTOS.add(newsClassDTO);
            });
            model.addAttribute("newsClassDTOS", newsClassDTOS);
            logger.info("news:" + (System.currentTimeMillis() - tt1));
        });
        CompletableFuture<Void> hotword = runnableExecutor(() -> {
            long tt1 = System.currentTimeMillis();
            model.addAttribute("hotword", hotWordService.getHot(7));
            logger.info("hot:" + (System.currentTimeMillis() - tt1));
        });
        CompletableFuture<Void> voidCompletableFuture1 = runnableExecutor(() -> {
            long tt1 = System.currentTimeMillis();
            ResponseList<Product> matong = productService.list(1, 6, null, "门窗");
            ResponseList<Product> matonggai = productService.list(1, 6, null, "门窗");
            model.addAttribute("matong", matong);
            model.addAttribute("matonggai", matonggai);
            logger.info("product:" + (System.currentTimeMillis() - tt1));
        });
        CompletableFuture<Void> voidCompletableFuture2 = runnableExecutor(() -> {
            long tt1 = System.currentTimeMillis();
            ResponseList<FunctionClass> functionClass = functionClassService.listFunction(1, 4, 1);
            List<FunctionClass> functionClassList = functionClass.getResult();
            List<functionClassDTO> functionClassDTOS = new ArrayList<>();
            functionClassList.forEach(v -> {
                functionClassDTO functionClassDTO = new functionClassDTO();
                BeanUtils.copyProperties(v, functionClassDTO, "list");
                functionClassDTO.setList(productService.getByFunctionId(v.getId(), 6));
                functionClassDTOS.add(functionClassDTO);
            });
            model.addAttribute("functionClassDTOS", functionClassDTOS);
            logger.info("function:" + (System.currentTimeMillis() - tt1));
        });
        CompletableFuture<Void> voidCompletableFuture3 = runnableExecutor(() -> {
            long tt1 = System.currentTimeMillis();
            model.addAttribute("navindex", navigationService.selectById(1));
            model.addAttribute("navMatong", navigationService.selectById(2));
            model.addAttribute("navMatonggai", navigationService.selectById(3));
            model.addAttribute("navFunction", navigationService.selectById(4));
            model.addAttribute("navNews", navigationService.selectById(5));
            model.addAttribute("navAboutme", navigationService.selectById(6));
            model.addAttribute("navMessage", navigationService.selectById(7));
            model.addAttribute("navApp", navigationService.selectById(8));
            logger.info("nav:" + (System.currentTimeMillis() - tt1));
        });
        try {
            CompletableFuture.allOf(voidCompletableFuture,voidCompletableFuture1,voidCompletableFuture2,voidCompletableFuture3,hotword).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "showPage/headpage/webmap";
    }


    //企业分站
    @GetMapping("/area")
    String area(Model model){
        headAndFooter(model);
        List<Navigation> navVOS = navigationService.showAllNav();
        model.addAttribute("navList",navVOS);
        model.addAttribute("northCityList",areaPart.getNorth_city());
        model.addAttribute("southCityList",areaPart.getSouth_city());
        model.addAttribute("northeastCityList",areaPart.getNortheast_city());
        model.addAttribute("northwestCityList",areaPart.getNorthwest_city());
        model.addAttribute("southwestCityList",areaPart.getSouthwest_city());
        model.addAttribute("eastCityList",areaPart.getEast_city());
        model.addAttribute("centerCityList",areaPart.getCenter_city());
        return "showPage/headpage/area";
    }


    //404
    @GetMapping("/404")
    String to404(Model model){
        return "error/404";
    }


    @GetMapping("api/user/login")
    String noPermission(){
        return "redirect:/404";
    }

    private void headAndFooter(Model model){
        CompletableFuture<Void> voidCompletableFutureNavList = getVoidCompletableFutureNavList(model);
        CompletableFuture<Void> voidCompletableFuture1 = getVoidCompletableFuture1(model);
        CompletableFuture<Void> voidCompletableFutureShop = getVoidCompletableFutureShop(model);
        CompletableFuture<Void> voidCompletableFuture = getVoidCompletableFuture(model);
        CompletableFuture<Void> voidCompletableFutureMessage = getVoidCompletableFutureMessage(model);
        CompletableFuture<Void> voidCompletableFutureAppImg = getVoidCompletableFutureAppImg(model);
        try {
            CompletableFuture.allOf(voidCompletableFuture,voidCompletableFuture1,voidCompletableFutureNavList,voidCompletableFutureShop,voidCompletableFutureMessage,voidCompletableFutureAppImg).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/yjv0lnjjCD.txt")
    private void readTxt(HttpServletResponse response){
        InputStream resourceAsStream = null;
        OutputStream outputStream = null;
        try {
            resourceAsStream = getClass().getClassLoader().getResourceAsStream("yjv0lnjjCD.txt");
            outputStream = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[1024 * 8];
            int count = 0;
            while ((count = resourceAsStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, count);
                outputStream.flush();
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resourceAsStream!=null){
                    resourceAsStream.close();
                }
                if (outputStream!=null){
                    outputStream.close();
                }
                response.flushBuffer();

            } catch (IOException e) {
                System.out.println("异常：" + e.toString());

            }
        }
    }
    private CompletableFuture<Void> runnableExecutor(Runnable runnable){
        return CompletableFuture.runAsync(runnable, taskExecutor);
    };


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
