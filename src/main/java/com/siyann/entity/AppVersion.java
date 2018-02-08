package com.siyann.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "app_version", schema = "tendaehome", catalog = "")
public class AppVersion {
    private int id;
    private String version;
    private String publisher;
    private Timestamp time;
    private String downloadUrl;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
    @Column(name = "download_url")
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppVersion that = (AppVersion) o;

        if (id != that.id) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (publisher != null ? !publisher.equals(that.publisher) : that.publisher != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (downloadUrl != null ? !downloadUrl.equals(that.downloadUrl) : that.downloadUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (downloadUrl != null ? downloadUrl.hashCode() : 0);
        return result;
    }
}
