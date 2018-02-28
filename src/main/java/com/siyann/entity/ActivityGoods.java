package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "activity_goods", schema = "tendaehome", catalog = "")
public class ActivityGoods {
    private long id;
    private long goodsId;
    private long actId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "act_id")
    public long getActId() {
        return actId;
    }

    public void setActId(long actId) {
        this.actId = actId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityGoods that = (ActivityGoods) o;

        if (id != that.id) return false;
        if (goodsId != that.goodsId) return false;
        if (actId != that.actId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (goodsId ^ (goodsId >>> 32));
        result = 31 * result + (int) (actId ^ (actId >>> 32));
        return result;
    }
}
