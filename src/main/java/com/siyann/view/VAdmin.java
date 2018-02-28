package com.siyann.view;

import javax.persistence.*;

@Entity
@Table(name = "v_admin", schema = "tendaehome", catalog = "")
public class VAdmin {
    private long id;
    private String username;
    private String password;
    private long time;
    private String createTime;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VAdmin vAdmin = (VAdmin) o;

        if (id != vAdmin.id) return false;
        if (time != vAdmin.time) return false;
        if (username != null ? !username.equals(vAdmin.username) : vAdmin.username != null) return false;
        if (password != null ? !password.equals(vAdmin.password) : vAdmin.password != null) return false;
        if (createTime != null ? !createTime.equals(vAdmin.createTime) : vAdmin.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
