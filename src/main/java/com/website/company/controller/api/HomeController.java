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


    //首页
    @GetMapping("/index")
    public ModelAndView toIndex(){
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/getIndexNews")
    @ResponseBody
    public Map<String,Object> getIndexNews(){
        Map<String,Object> map = new HashMap<>(3);
        Thread news1 = new Thread(()->{
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(2);
            BeanUtils.copyProperties(show,newsClassDTO,"list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            map.put("news1",newsClassDTO);
        });
        Thread news2 = new Thread(()->{
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(1);
            BeanUtils.copyProperties(show,newsClassDTO,"list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            map.put("news2",newsClassDTO);
        });
        Thread news3 = new Thread(()->{
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(3);
            BeanUtils.copyProperties(show,newsClassDTO,"list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            map.put("news3",newsClassDTO);
        });
        news1.start();
        news2.start();
        news3.start();
        try {
            news1.join();
            news2.join();
            news3.join();
        } catch (InterruptedException e) {
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
        Thread function = new Thread(()->{
            ResponseList<FunctionClass> list = functionClassService.listFunction(1, 10, 0);
            map.put("functions",list);
        });
        Thread Class = new Thread(()->{
            List<ProductClass> classList = productClassService.selectProductClassList();
            map.put("classList",classList);
        });
        function.start();
        Class.start();
        try {
            function.join();
            Class.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }




    @GetMapping("/")
    ModelAndView home(Model model, String area, HttpServletRequest request) throws InterruptedException{
        String requestURI = request.getRequestURI();
        Navigation navigation = navigationService.selectByUrl(requestURI);
        long start = System.currentTimeMillis();
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
        Thread banner = new Thread(()->{
            //banner信息
            List<Spanner> bannerPic = spannerService.list();
            model.addAttribute("bannerPic",bannerPic);
            //公告/活动
            List<BannerInfo> bannerInfos = bannerInfoService.selectBannerList();
            model.addAttribute("bannerInfo",bannerInfos);
        });
        Thread product = new Thread(()->{
            long s = System.currentTimeMillis();
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
            model.addAttribute("products",productDTOList);
            logger.info("product:"+(System.currentTimeMillis()-s));
        });
        Thread Class = new Thread(()->{
            long s1 = System.currentTimeMillis();
            List<ProductClass> classList = productClassService.selectProductClassList();
            model.addAttribute("classList",classList);
            long s2 = System.currentTimeMillis();
            logger.info("class1:"+(s2-s1));
        });
        Thread news1 = new Thread(()->{
            long t1 = System.currentTimeMillis();
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(2);
            BeanUtils.copyProperties(show,newsClassDTO,"list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            model.addAttribute("news1",newsClassDTO);
            long t2 = System.currentTimeMillis();
            logger.info("news1:"+(t2-t1));
        });
        Thread news2 = new Thread(()->{
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(1);
            BeanUtils.copyProperties(show,newsClassDTO,"list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            model.addAttribute("news2",newsClassDTO);
        });
        Thread news3 = new Thread(()->{
            NewsClassDTO newsClassDTO = new NewsClassDTO();
            NewsClass show = newsClassService.show(3);
            BeanUtils.copyProperties(show,newsClassDTO,"list");
            newsClassDTO.setList(newsMapper.getNewsList(show.getId()));
            model.addAttribute("news3",newsClassDTO);
        });
        Thread link = new Thread(()->{
            //关于我们
            CompanyInfo companyDetail = companyInfoService.getCompanyDetail();
            model.addAttribute("companyInfo",companyDetail);
            //友情链接
            model.addAttribute("links",linksService.list());
        });
        Thread function = new Thread(()->{
            ResponseList<FunctionClass> list = functionClassService.listFunction(1, 10, 0);
            model.addAttribute("functions",list);
        });
        banner.start();
        product.start();
        Class.start();
        link.start();
        news1.start();
        news2.start();
        news3.start();
        function.start();
        function.join();
        news1.join();
        news2.join();
        news3.join();
        banner.join();
        product.join();
        Class.join();
        link.join();
        long end2 = System.currentTimeMillis();
        logger.info("消耗时间"+(end2-start));
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
        channel.setTitle("重庆恭逸科技有限公司");
        channel.setDescription("重庆恭逸科技是一家致力于智能马桶、智能马桶盖、智能座便器，研发，生产，销售为一体的科技型公司。公司自主研发的智能体脂检测马桶盖，尿检马桶盖，便检马桶盖，智能按摩马桶盖获得20多项专利。");
        channel.setLink("https://www.gongyitech.com");
        channel.setUri("https://www.gongyitech.com");
        channel.setGenerator("恭逸");
        Date postDate = new Date();
        channel.setPubDate(postDate);
        List<Item> items=new ArrayList<>();
        List<News> newsList=newsService.allNews();
        List<Product> productList=productService.rssProductAll();
        newsList.forEach(v->{
            Item item = new Item();
            item.setTitle(v.getNewsTitle());
            item.setAuthor(v.getAuthor());
            item.setLink("https://www.gongyitech.com/newsDetail/newsId"+v.getId()+".html");
            item.setUri("https://www.gongyitech.com/newsDetail/newsId"+v.getId()+".html");
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
            item.setAuthor("恭逸科技");
            item.setLink("https://www.gongyitech.com/product/detail/"+v.getId()+".html");
            item.setUri("https://www.gongyitech.com/product/detail/"+v.getId()+".html");
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
        feed.setTitle("重庆恭逸科技有限公司");
        feed.setId("https://www.gongyitech.com");

        Content subtitle = new Content();
        subtitle.setType("text/plain");
        subtitle.setValue("https://www.gongyitech.com");
        feed.setSubtitle(subtitle);
        Date postDate = new Date();
        feed.setUpdated(postDate);

        List<News> newsList=newsService.allNews();
        List<Product> productList=productService.rssProductAll();
        List<Entry> entries=new ArrayList<>();
        newsList.forEach(v->{
            Entry entry = new Entry();
            Link link = new Link();
            link.setHref("https://www.gongyitech.com/newsDetail/newsId"+v.getId()+".html.");
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
            link.setHref("https://www.gongyitech.com/product/detail/"+v.getId()+".html");
            entry.setAlternateLinks(Collections.singletonList(link));
            SyndPerson author = new Person();
            author.setName("恭逸科技");
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
    @GetMapping("/robots.txt")
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
        Thread t1=new Thread(()->{
            long tt1=System.currentTimeMillis();
            List<NewsClassDTO> newsClassDTOS = new ArrayList<>();
            List<NewsClass> newsClasses = newsClassService.list();
            newsClasses.forEach(v -> {
                NewsClassDTO newsClassDTO = new NewsClassDTO();
                BeanUtils.copyProperties(v,newsClassDTO,"list");
                newsClassDTO.setList(newsService.indexNews(v.getId(),6));
                newsClassDTOS.add(newsClassDTO);
            });
            model.addAttribute("newsClassDTOS",newsClassDTOS);
            logger.info("news:"+(System.currentTimeMillis()-tt1));
        });
        Thread t2=new Thread(()->{
            long tt1=System.currentTimeMillis();
            model.addAttribute("hotword",hotWordService.getHot(7));
            logger.info("hot:"+(System.currentTimeMillis()-tt1));
        });
        Thread t3=new Thread(()->{
            long tt1=System.currentTimeMillis();
            ResponseList<Product> matong=productService.list(1,6,null,"智能马桶");
            ResponseList<Product> matonggai=productService.list(1,6,null,"智能马桶盖");
            model.addAttribute("matong",matong);
            model.addAttribute("matonggai",matonggai);
            logger.info("product:"+(System.currentTimeMillis()-tt1));
        });
        Thread t4=new Thread(()->{
            long tt1=System.currentTimeMillis();
            ResponseList<FunctionClass> functionClass=functionClassService.listFunction(1,10,1);
            List<FunctionClass> functionClassList=functionClass.getResult();
            List<functionClassDTO> functionClassDTOS = new ArrayList<>();
            functionClassList.forEach(v -> {
                functionClassDTO functionClassDTO = new functionClassDTO();
                BeanUtils.copyProperties(v,functionClassDTO,"list");
                functionClassDTO.setList(productService.getByFunctionId(v.getId(),6));
                functionClassDTOS.add(functionClassDTO);
            });
            model.addAttribute("functionClassDTOS",functionClassDTOS);
            logger.info("function:"+(System.currentTimeMillis()-tt1));
        });
        Thread t5=new Thread(()->{
            long tt1=System.currentTimeMillis();
            model.addAttribute("navindex",navigationService.selectById(1));
            model.addAttribute("navMatong",navigationService.selectById(2));
            model.addAttribute("navMatonggai",navigationService.selectById(3));
            model.addAttribute("navFunction",navigationService.selectById(4));
            model.addAttribute("navNews",navigationService.selectById(5));
            model.addAttribute("navAboutme",navigationService.selectById(6));
            model.addAttribute("navMessage",navigationService.selectById(7));
            model.addAttribute("navApp",navigationService.selectById(8));
            logger.info("nav:"+(System.currentTimeMillis()-tt1));
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t4.join();
        t5.join();
        t3.join();
        t1.join();
        t2.join();
        logger.info("alltime："+(System.currentTimeMillis()-start));
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
            //店铺
           List<Maison> list =  maisonService.selectList(new EntityWrapper<>());
           model.addAttribute("shop",list);
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
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
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


}
