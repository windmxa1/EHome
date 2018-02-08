package com.siyann.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Activity {
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

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (id != activity.id) return false;
        if (title != null ? !title.equals(activity.title) : activity.title != null) return false;
        if (url != null ? !url.equals(activity.url) : activity.url != null) return false;
        if (range != null ? !range.equals(activity.range) : activity.range != null) return false;
        if (startDate != null ? !startDate.equals(activity.startDate) : activity.startDate != null) return false;
        if (endDate != null ? !endDate.equals(activity.endDate) : activity.endDate != null) return false;
        if (useType != null ? !useType.equals(activity.useType) : activity.useType != null) return false;
        if (userGroupId != null ? !userGroupId.equals(activity.userGroupId) : activity.userGroupId != null)
            return false;
        if (maxPrice != null ? !maxPrice.equals(activity.maxPrice) : activity.maxPrice != null) return false;
        if (minPrice != null ? !minPrice.equals(activity.minPrice) : activity.minPrice != null) return false;
        if (type != null ? !type.equals(activity.type) : activity.type != null) return false;
        if (num != null ? !num.equals(activity.num) : activity.num != null) return false;

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
        return result;
    }
}
