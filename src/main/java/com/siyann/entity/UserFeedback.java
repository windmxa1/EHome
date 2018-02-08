package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_feedback", schema = "tendaehome", catalog = "")
public class UserFeedback {
    private int id;
    private String message;
    private long userId;
    private long time;
    private Byte read;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
    @Column(name = "read")
    public Byte getRead() {
        return read;
    }

    public void setRead(Byte read) {
        this.read = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFeedback that = (UserFeedback) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (time != that.time) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (read != null ? !read.equals(that.read) : that.read != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (read != null ? read.hashCode() : 0);
        return result;
    }
}
