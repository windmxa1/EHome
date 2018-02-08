package com.siyann.view;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "v_activity", schema = "tendaehome", catalog = "")
public class VActivity {
    private int id;
    private String title;
    private String url;
    private Integer range;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer useType;
    private Integer userGroupId;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;
    private Integer type;
    private Integer num;
    private String goods;
    private String gift;
    private String typeName;

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "range")
    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "use_type")
    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    @Basic
    @Column(name = "user_group_id")
    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    @Basic
    @Column(name = "maxPrice")
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Basic
    @Column(name = "minPrice")
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
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
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "goods")
    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    @Basic
    @Column(name = "gift")
    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VActivity vActivity = (VActivity) o;

        if (id != vActivity.id) return false;
        if (title != null ? !title.equals(vActivity.title) : vActivity.title != null) return false;
        if (url != null ? !url.equals(vActivity.url) : vActivity.url != null) return false;
        if (range != null ? !range.equals(vActivity.range) : vActivity.range != null) return false;
        if (startDate != null ? !startDate.equals(vActivity.startDate) : vActivity.startDate != null) return false;
        if (endDate != null ? !endDate.equals(vActivity.endDate) : vActivity.endDate != null) return false;
        if (useType != null ? !useType.equals(vActivity.useType) : vActivity.useType != null) return false;
        if (userGroupId != null ? !userGroupId.equals(vActivity.userGroupId) : vActivity.userGroupId != null)
            return false;
        if (maxPrice != null ? !maxPrice.equals(vActivity.maxPrice) : vActivity.maxPrice != null) return false;
        if (minPrice != null ? !minPrice.equals(vActivity.minPrice) : vActivity.minPrice != null) return false;
        if (type != null ? !type.equals(vActivity.type) : vActivity.type != null) return false;
        if (num != null ? !num.equals(vActivity.num) : vActivity.num != null) return false;
        if (goods != null ? !goods.equals(vActivity.goods) : vActivity.goods != null) return false;
        if (gift != null ? !gift.equals(vActivity.gift) : vActivity.gift != null) return false;
        if (typeName != null ? !typeName.equals(vActivity.typeName) : vActivity.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (range != null ? range.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (useType != null ? useType.hashCode() : 0);
        result = 31 * result + (userGroupId != null ? userGroupId.hashCode() : 0);
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (goods != null ? goods.hashCode() : 0);
        result = 31 * result + (gift != null ? gift.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
