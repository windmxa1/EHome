package com.siyann.entity;

import javax.persistence.*;

@Entity
@Table(name = "garousel_catalog", schema = "tendaehome", catalog = "")
public class GarouselCatalog {
    private int id;
    private String garouselCatalog;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "garousel_catalog")
    public String getGarouselCatalog() {
        return garouselCatalog;
    }

    public void setGarouselCatalog(String garouselCatalog) {
        this.garouselCatalog = garouselCatalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GarouselCatalog that = (GarouselCatalog) o;

        if (id != that.id) return false;
        if (garouselCatalog != null ? !garouselCatalog.equals(that.garouselCatalog) : that.garouselCatalog != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (garouselCatalog != null ? garouselCatalog.hashCode() : 0);
        return result;
    }
}
