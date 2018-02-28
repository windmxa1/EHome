package com.siyann.view;

import javax.persistence.*;

@Entity
@Table(name = "v_garousel", schema = "tendaehome", catalog = "")
public class VGarousel {
    private long id;
    private String title;
    private String url;
    private int catalogId;
    private String hyperlink;
    private Long time;
    private String catalog;
    private String gerouselUrl;
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

    @Basic
    @Column(name = "catalog")
    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    @Basic
    @Column(name = "gerousel_url")
    public String getGerouselUrl() {
        return gerouselUrl;
    }

    public void setGerouselUrl(String gerouselUrl) {
        this.gerouselUrl = gerouselUrl;
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

        VGarousel vGarousel = (VGarousel) o;

        if (id != vGarousel.id) return false;
        if (catalogId != vGarousel.catalogId) return false;
        if (title != null ? !title.equals(vGarousel.title) : vGarousel.title != null) return false;
        if (url != null ? !url.equals(vGarousel.url) : vGarousel.url != null) return false;
        if (hyperlink != null ? !hyperlink.equals(vGarousel.hyperlink) : vGarousel.hyperlink != null) return false;
        if (time != null ? !time.equals(vGarousel.time) : vGarousel.time != null) return false;
        if (catalog != null ? !catalog.equals(vGarousel.catalog) : vGarousel.catalog != null) return false;
        if (gerouselUrl != null ? !gerouselUrl.equals(vGarousel.gerouselUrl) : vGarousel.gerouselUrl != null)
            return false;
        if (createTime != null ? !createTime.equals(vGarousel.createTime) : vGarousel.createTime != null) return false;

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
        result = 31 * result + (catalog != null ? catalog.hashCode() : 0);
        result = 31 * result + (gerouselUrl != null ? gerouselUrl.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
