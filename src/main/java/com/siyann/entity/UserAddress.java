package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_address", schema = "tendaehome", catalog = "")
//@NamedStoredProcedureQueries({
//        @NamedStoredProcedureQuery(name = "update_default_address", procedureName = "update_default_address", parameters = {@StoredProcedureParameter(name = "userid", type = Long.class), @StoredProcedureParameter(name = "id", type = Long.class)})
//})
public class UserAddress {
    private long id;
    private long userid;
    private String address;
    private String receiver;
    private Integer default_;
    private String tel;
    private String sex;

    public UserAddress() {
    }

    public UserAddress(long userid, String address, String receiver, String tel, String sex) {
        this.userid = userid;
        this.address = address;
        this.receiver = receiver;
        this.tel = tel;
        this.sex = sex;
    }

    public UserAddress(long id, long userid) {
        this.id = id;
        this.userid = userid;
    }

    public UserAddress(long userid, String address, String receiver, Integer default_, String tel, String sex) {
        this.userid = userid;
        this.address = address;
        this.receiver = receiver;
        this.default_ = default_;
        this.tel = tel;
        this.sex = sex;
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
    @Column(name = "userid")
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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
    @Column(name = "receiver")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "default_")
    public Integer getDefault_() {
        return default_;
    }

    public void setDefault_(Integer default_) {
        this.default_ = default_;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAddress that = (UserAddress) o;

        if (id != that.id) return false;
        if (userid != that.userid) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (receiver != null ? !receiver.equals(that.receiver) : that.receiver != null) return false;
        if (default_ != null ? !default_.equals(that.default_) : that.default_ != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userid ^ (userid >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        result = 31 * result + (default_ != null ? default_.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
