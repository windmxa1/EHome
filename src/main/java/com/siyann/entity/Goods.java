package com.siyann.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Goods {
    private long id;
    private String name;
    private BigDecimal price;
    private String url;
    private long catalogId;
    private String description;
    private long time;
    private String origin;
    private Byte state;
    private String unitName;
    private Integer unitNum;
    private Long saleNum;
    private BigDecimal originPrice;
    private Integer type;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "origin")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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
    @Column(name = "unit_name")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Basic
    @Column(name = "unit_num")
    public Integer getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Integer unitNum) {
        this.unitNum = unitNum;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (id != goods.id) return false;
        if (catalogId != goods.catalogId) return false;
        if (time != goods.time) return false;
        if (name != null ? !name.equals(goods.name) : goods.name != null) return false;
        if (price != null ? !price.equals(goods.price) : goods.price != null) return false;
        if (url != null ? !url.equals(goods.url) : goods.url != null) return false;
        if (description != null ? !description.equals(goods.description) : goods.description != null) return false;
        if (origin != null ? !origin.equals(goods.origin) : goods.origin != null) return false;
        if (state != null ? !state.equals(goods.state) : goods.state != null) return false;
        if (unitName != null ? !unitName.equals(goods.unitName) : goods.unitName != null) return false;
        if (unitNum != null ? !unitNum.equals(goods.unitNum) : goods.unitNum != null) return false;
        if (saleNum != null ? !saleNum.equals(goods.saleNum) : goods.saleNum != null) return false;
        if (originPrice != null ? !originPrice.equals(goods.originPrice) : goods.originPrice != null) return false;
        if (type != null ? !type.equals(goods.type) : goods.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (int) (catalogId ^ (catalogId >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (unitNum != null ? unitNum.hashCode() : 0);
        result = 31 * result + (saleNum != null ? saleNum.hashCode() : 0);
        result = 31 * result + (originPrice != null ? originPrice.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
