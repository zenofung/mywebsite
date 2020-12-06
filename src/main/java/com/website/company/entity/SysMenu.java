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

/**
 * <p>
 *
 * </p>
 *
 * @author pengyangyan
 * @since 2018-09-28
 */
@Entity
@Table(name = "sys_menu")
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 创建时间
     */
    @TableField(value = "create_datetime")
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDatetime;
    /**
     * 更新时间
     */
    @TableField("update_datetime")
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDatetime;
    /**
     * 菜单名称
     */
    @TableField("menu_name")
    @Column
    private String menuName;
    /**
     * 菜单url地址
     */
    @TableField("menu_url")
    @Column
    private String menuUrl;
    /**
     * 图标地址
     */
    @TableField("menu_icon")
    @Column
    private String menuIcon;
    /**
     * 同级菜单的权重，值越大排列越靠前
     */
    @TableField("menu_pid")
    @Column
    private Integer menuPid;
    /**
     * 菜单的等级（1表示一级，2表示二级，3表示三级）
     */
    @TableField("menu_level")
    @Column
    private Integer menuLevel;
    /**
     * 更新菜单节点的user的Id
     */
    @TableField("update_id")
    @Column
    private Integer updateId;
    /**
     * 删除标志位（0表示存在，1表示已删除）
     */
    @TableField("is_deleted")
    @Column
    private Integer isDeleted;
    /**
     * 父级id
     */
    @TableField("parent_id")
    @Column
    private Integer parentId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer meunLevel) {
        this.menuLevel = meunLevel;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", createDatetime=" + createDatetime +
                ", updateDatetime=" + updateDatetime +
                ", menuName=" + menuName +
                ", menuUrl=" + menuUrl +
                ", menuIcon=" + menuIcon +
                ", menuPid=" + menuPid +
                ", menuLevel=" + menuLevel +
                ", updateId=" + updateId +
                ", isDeleted=" + isDeleted +
                ", parentId=" + parentId +
                "}";
    }
}
