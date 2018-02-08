package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "repair_comment", schema = "tendaehome", catalog = "")
public class RepairComment {
    private long id;
    private int point;
    private String description;
    private String suggestion;
    private String staffNo;
    private long userid;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "point")
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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
    @Column(name = "suggestion")
    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
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
    @Column(name = "userid")
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepairComment that = (RepairComment) o;

        if (id != that.id) return false;
        if (point != that.point) return false;
        if (userid != that.userid) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (suggestion != null ? !suggestion.equals(that.suggestion) : that.suggestion != null) return false;
        if (staffNo != null ? !staffNo.equals(that.staffNo) : that.staffNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + point;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (suggestion != null ? suggestion.hashCode() : 0);
        result = 31 * result + (staffNo != null ? staffNo.hashCode() : 0);
        result = 31 * result + (int) (userid ^ (userid >>> 32));
        return result;
    }
}
