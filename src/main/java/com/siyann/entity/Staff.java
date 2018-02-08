package com.siyann.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staff {
    private int id;
    private String staffNo;
    private String staffName;
    private Integer year;
    private String serviceVange;
    private String username;
    private String password;
    private Integer isLeader;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "staff_name")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "service_vange")
    public String getServiceVange() {
        return serviceVange;
    }

    public void setServiceVange(String serviceVange) {
        this.serviceVange = serviceVange;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    @Column(name = "is_leader")
    public Integer getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != staff.id) return false;
        if (staffNo != null ? !staffNo.equals(staff.staffNo) : staff.staffNo != null) return false;
        if (staffName != null ? !staffName.equals(staff.staffName) : staff.staffName != null) return false;
        if (year != null ? !year.equals(staff.year) : staff.year != null) return false;
        if (serviceVange != null ? !serviceVange.equals(staff.serviceVange) : staff.serviceVange != null) return false;
        if (username != null ? !username.equals(staff.username) : staff.username != null) return false;
        if (password != null ? !password.equals(staff.password) : staff.password != null) return false;
        if (isLeader != null ? !isLeader.equals(staff.isLeader) : staff.isLeader != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (staffNo != null ? staffNo.hashCode() : 0);
        result = 31 * result + (staffName != null ? staffName.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (serviceVange != null ? serviceVange.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (isLeader != null ? isLeader.hashCode() : 0);
        return result;
    }
}
