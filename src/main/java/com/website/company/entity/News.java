package com.website.company.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "news")
@TableName("news")
public class News extends Model<News> {

    private static final long serialVersionUID = 1L;
    /**
     * 唯一标识
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 创建时间
     */
    @TableField("create_datetime")
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDatetime;
    /**
     * 修改时间
     */
    @TableField("update_datetime")
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDatetime;
    /**
     * 新闻标题
     */
    @TableField("news_title")
    @Column(name = "news_title")
    private String newsTitle;
    /**
     * 新闻描述
     */
    @Column
    @TableField("description")
    private String description;
    /**
     * 关键词
     */
    @Column
    @TableField("keywords")
    private String keywords;
    /**
     * 新闻作者
     */
    @TableField("author")
    @Column(name = "author")
    private String author;
    /**
     * 新闻正文
     */
    @Column
    @TableField("content")
    private String content;
    /**
     * 新闻地址
     */
    @Column(name = "url")
    @TableField("url")
    private String url;
    /**
     * 新闻类别id
     */
    @TableField("news_class_id")
    @Column(name = "news_class_id")
    private Integer newsClassId;

    /**
     * 新闻图片
     */
    @TableField("pic")
    @Column(name = "pic")
    private String pic;

    /**
     * 新闻手机图片
     */
    @TableField("mobile_pic")
    @Column(name = "mobile_pic")
    private String mobilePic;

    /**
     * 是否置顶 1-是  0-否
     */
    @TableField("top")
    @Column(name = "top")
    private Integer top;

    /**
     * 访问次数
     */
    @TableField("visit_num")
    @Column(name = "visit_num")
    private Integer visitNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNewsClassId() {
        return newsClassId;
    }

    public void setNewsClassId(Integer newsClassId) {
        this.newsClassId = newsClassId;
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

    public String getMobilePic() {
        return mobilePic;
    }

    public void setMobilePic(String mobilePic) {
        this.mobilePic = mobilePic;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
