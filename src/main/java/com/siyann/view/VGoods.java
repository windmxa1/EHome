package com.siyann.view;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "v_goods", schema = "tendaehome", catalog = "")
public class VGoods {
    private long goodsId;
    private String name;
    private BigDecimal price;
    private String url;
    private long catalogId;
    private String description;
    private long time;
    private Byte state;
    private Long saleNum;
    private BigDecimal originPrice;
    private Integer type;
    private String actType;
    private String actId;
    private String actName;
    private String status;
    private String unit;
    private String createTime;
    private String catalog;
    private Long count;
    private String goodsUrl;
    private String origin;

    @Basic
    @Id
    @Column(name = "goods_id")
    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "catalog_id")
    public long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(long catalogId) {
        this.catalogId = catalogId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "time")
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Basic
    @Column(name = "state")
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "sale_num")
    public Long getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Long saleNum) {
        this.saleNum = saleNum;
    }

    @Basic
    @Column(name = "origin_price")
    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
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
    @Column(name = "act_type")
    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    @Basic
    @Column(name = "act_id")
    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    @Basic
    @Column(name = "act_name")
    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "catalog")
    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    @Basic
    @Column(name = "count")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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
    @Column(name = "origin")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VGoods vGoods = (VGoods) o;

        if (goodsId != vGoods.goodsId) return false;
        if (catalogId != vGoods.catalogId) return false;
        if (time != vGoods.time) return false;
        if (name != null ? !name.equals(vGoods.name) : vGoods.name != null) return false;
        if (price != null ? !price.equals(vGoods.price) : vGoods.price != null) return false;
        if (url != null ? !url.equals(vGoods.url) : vGoods.url != null) return false;
        if (description != null ? !description.equals(vGoods.description) : vGoods.description != null) return false;
        if (state != null ? !state.equals(vGoods.state) : vGoods.state != null) return false;
        if (saleNum != null ? !saleNum.equals(vGoods.saleNum) : vGoods.saleNum != null) return false;
        if (originPrice != null ? !originPrice.equals(vGoods.originPrice) : vGoods.originPrice != null) return false;
        if (type != null ? !type.equals(vGoods.type) : vGoods.type != null) return false;
        if (actType != null ? !actType.equals(vGoods.actType) : vGoods.actType != null) return false;
        if (actId != null ? !actId.equals(vGoods.actId) : vGoods.actId != null) return false;
        if (actName != null ? !actName.equals(vGoods.actName) : vGoods.actName != null) return false;
        if (status != null ? !status.equals(vGoods.status) : vGoods.status != null) return false;
        if (unit != null ? !unit.equals(vGoods.unit) : vGoods.unit != null) return false;
        if (createTime != null ? !createTime.equals(vGoods.createTime) : vGoods.createTime != null) return false;
        if (catalog != null ? !catalog.equals(vGoods.catalog) : vGoods.catalog != null) return false;
        if (count != null ? !count.equals(vGoods.count) : vGoods.count != null) return false;
        if (goodsUrl != null ? !goodsUrl.equals(vGoods.goodsUrl) : vGoods.goodsUrl != null) return false;
        if (origin != null ? !origin.equals(vGoods.origin) : vGoods.origin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (goodsId ^ (goodsId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (int) (catalogId ^ (catalogId >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (saleNum != null ? saleNum.hashCode() : 0);
        result = 31 * result + (originPrice != null ? originPrice.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (actType != null ? actType.hashCode() : 0);
        result = 31 * result + (actId != null ? actId.hashCode() : 0);
        result = 31 * result + (actName != null ? actName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (catalog != null ? catalog.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (goodsUrl != null ? goodsUrl.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        return result;
    }
}
