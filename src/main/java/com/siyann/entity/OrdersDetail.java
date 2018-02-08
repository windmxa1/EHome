package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders_detail", schema = "tendaehome", catalog = "")
public class OrdersDetail {
    private long id;
    private long orderId;
    private long goodsId;
    private int num;

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
    @Column(name = "goods_id")
    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersDetail that = (OrdersDetail) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (goodsId != that.goodsId) return false;
        if (num != that.num) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (goodsId ^ (goodsId >>> 32));
        result = 31 * result + num;
        return result;
    }
}
