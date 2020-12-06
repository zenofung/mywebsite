package com.website.company.entity;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_function_relation")
@TableName("product_function_relation")
public class ProductFunctionRelation extends Model<ProductFunctionRelation> {

    private static final long serialVersionUID = 1L;

    public ProductFunctionRelation() {
    }

    public ProductFunctionRelation(Integer productId, Integer functionId) {
        this.productId = productId;
        this.functionId = functionId;
    }

    /**
     * 唯一标识
     */


    @Id
    @TableId(value = "id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    @TableField("product_id")
    private Integer productId;

    @Column(name = "function_id")
    @TableField("function_id")
    private Integer functionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
