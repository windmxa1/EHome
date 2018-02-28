package com.siyann.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private long id;
    private String phone;
    private String password;
    private long time;
    private String nickname;
    private String headUrl;
    private Integer partner;
    private Integer isFree;

    public User() {

    }

    public User(String phone, String password, long time) {
        this.phone = phone;
        this.password = password;
        this.time = time;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "head_url")
    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    @Basic
    @Column(name = "partner")
    public Integer getPartner() {
        return partner;
    }

    public void setPartner(Integer partner) {
        this.partner = partner;
    }

    @Basic
    @Column(name = "is_free")
    public Integer getIsFree() {
        return isFree;
    }

    public void setIsFree(Integer isFree) {
        this.isFree = isFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (time != user.time) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (headUrl != null ? !headUrl.equals(user.headUrl) : user.headUrl != null) return false;
        if (partner != null ? !partner.equals(user.partner) : user.partner != null) return false;
        if (isFree != null ? !isFree.equals(user.isFree) : user.isFree != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (headUrl != null ? headUrl.hashCode() : 0);
        result = 31 * result + (partner != null ? partner.hashCode() : 0);
        result = 31 * result + (isFree != null ? isFree.hashCode() : 0);
        return result;
    }
}
