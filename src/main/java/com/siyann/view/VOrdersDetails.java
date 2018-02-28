package com.siyann.view;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "v_orders_details", schema = "tendaehome", catalog = "")
public class VOrdersDetails {
    private long id;
    private long orderId;
    private String orderNum;
    private long goodsId;
    private String goodsName;
    private Integer type;
    private String origin;
    private String totalNum;
    private String goodsUrl;
    private int num;
    private BigDecimal prices;

    @Basic
    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_num")
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "goods_id")
    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "origin")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic
    @Column(name = "total_num")
    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    @Basic
    @Column(name = "goods_url")
    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "prices")
    public BigDecimal getPrices() {
        return prices;
    }

    public void setPrices(BigDecimal prices) {
        this.prices = prices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VOrdersDetails that = (VOrdersDetails) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (goodsId != that.goodsId) return false;
        if (num != that.num) return false;
        if (orderNum != null ? !orderNum.equals(that.orderNum) : that.orderNum != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (totalNum != null ? !totalNum.equals(that.totalNum) : that.totalNum != null) return false;
        if (goodsUrl != null ? !goodsUrl.equals(that.goodsUrl) : that.goodsUrl != null) return false;
        if (prices != null ? !prices.equals(that.prices) : that.prices != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (int) (goodsId ^ (goodsId >>> 32));
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (totalNum != null ? totalNum.hashCode() : 0);
        result = 31 * result + (goodsUrl != null ? goodsUrl.hashCode() : 0);
        result = 31 * result + num;
        result = 31 * result + (prices != null ? prices.hashCode() : 0);
        return result;
    }
}
