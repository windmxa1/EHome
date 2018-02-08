package com.siyann.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Garousel {
    private long id;
    private String title;
    private String url;
    private int catalogId;
    private String hyperlink;
    private Long time;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "catalog_id")
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    @Basic
    @Column(name = "hyperlink")
    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    @Basic
    @Column(name = "time")
    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Garousel garousel = (Garousel) o;

        if (id != garousel.id) return false;
        if (catalogId != garousel.catalogId) return false;
        if (title != null ? !title.equals(garousel.title) : garousel.title != null) return false;
        if (url != null ? !url.equals(garousel.url) : garousel.url != null) return false;
        if (hyperlink != null ? !hyperlink.equals(garousel.hyperlink) : garousel.hyperlink != null) return false;
        if (time != null ? !time.equals(garousel.time) : garousel.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + catalogId;
        result = 31 * result + (hyperlink != null ? hyperlink.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
