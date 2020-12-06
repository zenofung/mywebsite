package com.website.company.utils;


import java.util.Date;
import java.util.List;

public class SysMenuDTO {
    private Integer id;
    /**
     * 创建时间
     */
    private Date createDatetime;
    /**
     * 更新时间
     */
    private Date updateDatetime;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单url地址
     */
    private String menuUrl;
    /**
     * 图标地址
     */
    private String menuIcon;
    /**
     * 同级菜单的权重，值越大排列越靠前
     */
    private Integer menuPid;
    /**
     * 菜单的等级（1表示一级，2表示二级，3表示三级）
     */
    private Integer menuLevel;
    /**
     * 更新菜单节点的user的Id
     */
    private Integer updateId;
    /**
     * 删除标志位（0表示存在，1表示已删除）
     */
    private Integer isDeleted;
    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 子集列表
     */
    private List<SysMenuDTO> children;


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

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
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

    public List<SysMenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuDTO> children) {
        this.children = children;
    }
}
