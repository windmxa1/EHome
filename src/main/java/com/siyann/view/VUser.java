package com.siyann.view;

import javax.persistence.*;

@Entity
@Table(name = "v_user", schema = "tendaehome", catalog = "")
public class VUser {
    private long id;
    private String phone;
    private String password;
    private long time;
    private String nickname;
    private String headUrl;
    private String createTime;
    private String url;
    private String address;
    private Integer addressId;
    private Integer isFree;


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
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "address_id")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

        VUser vUser = (VUser) o;

        if (id != vUser.id) return false;
        if (time != vUser.time) return false;
        if (phone != null ? !phone.equals(vUser.phone) : vUser.phone != null) return false;
        if (password != null ? !password.equals(vUser.password) : vUser.password != null) return false;
        if (nickname != null ? !nickname.equals(vUser.nickname) : vUser.nickname != null) return false;
        if (headUrl != null ? !headUrl.equals(vUser.headUrl) : vUser.headUrl != null) return false;
        if (createTime != null ? !createTime.equals(vUser.createTime) : vUser.createTime != null) return false;
        if (url != null ? !url.equals(vUser.url) : vUser.url != null) return false;
        if (address != null ? !address.equals(vUser.address) : vUser.address != null) return false;
        if (addressId != null ? !addressId.equals(vUser.addressId) : vUser.addressId != null) return false;
        if (isFree != null ? !isFree.equals(vUser.isFree) : vUser.isFree != null) return false;

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
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (isFree != null ? isFree.hashCode() : 0);
        return result;
    }
}
