package com.siyann.view;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "v_franchisee", schema = "tendaehome", catalog = "")
public class VFranchisee {
    private long id;
    private String franchiseeNum;
    private String nickname;
    private String name;
    private String address;
    private String phone;
    private String healthPic;
    private String promissPic;
    private String ipc;
    private String lat;
    private String lon;
    private Long userid;
    private Integer catalogId;
    private Integer state;
    private String description;
    private BigDecimal rating;

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
    @Column(name = "franchisee_num")
    public String getFranchiseeNum() {
        return franchiseeNum;
    }

    public void setFranchiseeNum(String franchiseeNum) {
        this.franchiseeNum = franchiseeNum;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "health_pic")
    public String getHealthPic() {
        return healthPic;
    }

    public void setHealthPic(String healthPic) {
        this.healthPic = healthPic;
    }

    @Basic
    @Column(name = "promiss_pic")
    public String getPromissPic() {
        return promissPic;
    }

    public void setPromissPic(String promissPic) {
        this.promissPic = promissPic;
    }

    @Basic
    @Column(name = "ipc")
    public String getIpc() {
        return ipc;
    }

    public void setIpc(String ipc) {
        this.ipc = ipc;
    }

    @Basic
    @Column(name = "lat")
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "lon")
    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Basic
    @Column(name = "userid")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "catalog_id")
    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VFranchisee that = (VFranchisee) o;

        if (id != that.id) return false;
        if (franchiseeNum != null ? !franchiseeNum.equals(that.franchiseeNum) : that.franchiseeNum != null)
            return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (healthPic != null ? !healthPic.equals(that.healthPic) : that.healthPic != null) return false;
        if (promissPic != null ? !promissPic.equals(that.promissPic) : that.promissPic != null) return false;
        if (ipc != null ? !ipc.equals(that.ipc) : that.ipc != null) return false;
        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        if (lon != null ? !lon.equals(that.lon) : that.lon != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (catalogId != null ? !catalogId.equals(that.catalogId) : that.catalogId != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (franchiseeNum != null ? franchiseeNum.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (healthPic != null ? healthPic.hashCode() : 0);
        result = 31 * result + (promissPic != null ? promissPic.hashCode() : 0);
        result = 31 * result + (ipc != null ? ipc.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (lon != null ? lon.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (catalogId != null ? catalogId.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
