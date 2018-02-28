package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "goods_catalog", schema = "tendaehome", catalog = "")
public class GoodsCatalog {
    private long id;
    private String catalog;
    private String url;
    private String description;
    private Integer type;

    public GoodsCatalog(String catalog, String url, String description, Integer type) {
        this.catalog = catalog;
        this.url = url;
        this.description = description;
        this.type = type;
    }

    public GoodsCatalog(long id, String catalog, String url, String description, Integer type) {
        this.id = id;
        this.catalog = catalog;
        this.url = url;
        this.description = description;
        this.type = type;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsCatalog that = (GoodsCatalog) o;

        if (id != that.id) return false;
        if (catalog != null ? !catalog.equals(that.catalog) : that.catalog != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (catalog != null ? catalog.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
