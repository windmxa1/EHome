package com.siyann.view;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "v_tv", schema = "tendaehome", catalog = "")
public class VTv {
    private int id;
    private String name;
    private String imgUrl;
    private String tvUrl;
    private long time;
    private String createTime;
    private int available;

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "tv_url")
    public String getTvUrl() {
        return tvUrl;
    }

    public void setTvUrl(String tvUrl) {
        this.tvUrl = tvUrl;
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
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "available")
    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VTv vTv = (VTv) o;

        if (id != vTv.id) return false;
        if (time != vTv.time) return false;
        if (available != vTv.available) return false;
        if (name != null ? !name.equals(vTv.name) : vTv.name != null) return false;
        if (imgUrl != null ? !imgUrl.equals(vTv.imgUrl) : vTv.imgUrl != null) return false;
        if (tvUrl != null ? !tvUrl.equals(vTv.tvUrl) : vTv.tvUrl != null) return false;
        if (createTime != null ? !createTime.equals(vTv.createTime) : vTv.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (tvUrl != null ? tvUrl.hashCode() : 0);
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + available;
        return result;
    }
}
