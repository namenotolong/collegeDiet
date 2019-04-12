package com.swpu.diet_healthydomain;


import java.sql.Date;

public class Flavor {
    private Integer id;
    private String name;
    private String creation;
    private String modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Flavor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creation=" + creation +
                ", modified=" + modified +
                '}';
    }
}
