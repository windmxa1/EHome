package com.siyann.view;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "v_staff_promotion", schema = "tendaehome", catalog = "")
public class VStaffPromotion {
    private long id;
    private String address;
    private String staffNo;
    private Timestamp time;
    private String staffName;

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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "staff_no")
    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
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
    @Column(name = "staff_name")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VStaffPromotion that = (VStaffPromotion) o;

        if (id != that.id) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (staffNo != null ? !staffNo.equals(that.staffNo) : that.staffNo != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (staffName != null ? !staffName.equals(that.staffName) : that.staffName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (staffNo != null ? staffNo.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (staffName != null ? staffName.hashCode() : 0);
        return result;
    }
}
