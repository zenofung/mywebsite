package com.website.company.utils.entityVO;

import java.util.List;

public class NewsVO {
    private Integer id;
    private String createDate;//发布日期
    private String newsTitle;//标题
    private String description;//描述
    private String author;//作者
    private String content;
    private String url;//新闻链接
    private Integer newsClassId;//类别
    private Integer visitNum;//访问量
    private String[] keywords;//关键词
    private String pic;//图片位置
    private Integer top;//置顶

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNewsClassId() {
        return newsClassId;
    }

    public void setNewsClassId(Integer newsClassId) {
        this.newsClassId = newsClassId;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
}
