package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "repair_order", schema = "tendaehome", catalog = "")
public class RepairOrder {
    private long id;
    private String appointmentTime;
    private String address;
    private String description;
    private String phone;
    private Integer status;
    private String handleResult;
    private long userid;
    private Integer staffId;
    private Integer isRead;
    private Integer isStaffRead;
    private String lat;
    private String lon;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "appointment_time")
    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "handle_result")
    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
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
    @Column(name = "staff_id")
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "is_read")
    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    @Basic
    @Column(name = "is_staff_read")
    public Integer getIsStaffRead() {
        return isStaffRead;
    }

    public void setIsStaffRead(Integer isStaffRead) {
        this.isStaffRead = isStaffRead;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepairOrder that = (RepairOrder) o;

        if (id != that.id) return false;
        if (userid != that.userid) return false;
        if (appointmentTime != null ? !appointmentTime.equals(that.appointmentTime) : that.appointmentTime != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (handleResult != null ? !handleResult.equals(that.handleResult) : that.handleResult != null) return false;
        if (staffId != null ? !staffId.equals(that.staffId) : that.staffId != null) return false;
        if (isRead != null ? !isRead.equals(that.isRead) : that.isRead != null) return false;
        if (isStaffRead != null ? !isStaffRead.equals(that.isStaffRead) : that.isStaffRead != null) return false;
        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        if (lon != null ? !lon.equals(that.lon) : that.lon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (appointmentTime != null ? appointmentTime.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (handleResult != null ? handleResult.hashCode() : 0);
        result = 31 * result + (int) (userid ^ (userid >>> 32));
        result = 31 * result + (staffId != null ? staffId.hashCode() : 0);
        result = 31 * result + (isRead != null ? isRead.hashCode() : 0);
        result = 31 * result + (isStaffRead != null ? isStaffRead.hashCode() : 0);
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (lon != null ? lon.hashCode() : 0);
        return result;
    }
}
