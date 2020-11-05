package com.example.demo.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "regions")
public class Region {
    @Id
    @Column(name = "region_id")
    private Integer regionId;
    @Column(name = "region_name")
    private String regionName;

    public Integer getRegionId() {
        return regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
