package com.siyann.view;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "v_comment", schema = "tendaehome", catalog = "")
public class VComment {
    private long id;
    private String description;
    private Integer rating;
    private long userid;
    private long orderId;
    private Integer isVisable;
    private Timestamp time;
    private String reply;
    private String headImg;
    private Long catalogId;
    private String franchiseeName;
    private String nickname;
    private String imgUrl;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "userid")
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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
    @Column(name = "is_visable")
    public Integer getIsVisable() {
        return isVisable;
    }

    public void setIsVisable(Integer isVisable) {
        this.isVisable = isVisable;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "reply")
    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Basic
    @Column(name = "head_img")
    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    @Basic
    @Column(name = "catalog_id")
    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    @Basic
    @Column(name = "franchisee_name")
    public String getFranchiseeName() {
        return franchiseeName;
    }

    public void setFranchiseeName(String franchiseeName) {
        this.franchiseeName = franchiseeName;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VComment vComment = (VComment) o;

        if (id != vComment.id) return false;
        if (userid != vComment.userid) return false;
        if (orderId != vComment.orderId) return false;
        if (description != null ? !description.equals(vComment.description) : vComment.description != null)
            return false;
        if (rating != null ? !rating.equals(vComment.rating) : vComment.rating != null) return false;
        if (isVisable != null ? !isVisable.equals(vComment.isVisable) : vComment.isVisable != null) return false;
        if (time != null ? !time.equals(vComment.time) : vComment.time != null) return false;
        if (reply != null ? !reply.equals(vComment.reply) : vComment.reply != null) return false;
        if (headImg != null ? !headImg.equals(vComment.headImg) : vComment.headImg != null) return false;
        if (catalogId != null ? !catalogId.equals(vComment.catalogId) : vComment.catalogId != null) return false;
        if (franchiseeName != null ? !franchiseeName.equals(vComment.franchiseeName) : vComment.franchiseeName != null)
            return false;
        if (nickname != null ? !nickname.equals(vComment.nickname) : vComment.nickname != null) return false;
        if (imgUrl != null ? !imgUrl.equals(vComment.imgUrl) : vComment.imgUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (int) (userid ^ (userid >>> 32));
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (isVisable != null ? isVisable.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (reply != null ? reply.hashCode() : 0);
        result = 31 * result + (headImg != null ? headImg.hashCode() : 0);
        result = 31 * result + (catalogId != null ? catalogId.hashCode() : 0);
        result = 31 * result + (franchiseeName != null ? franchiseeName.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }
}
