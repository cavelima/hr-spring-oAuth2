package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "countries")
public class Country {
    @Id
    @Column(name = "country_id")
    private String countryId;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "region_id")
    private Integer regionId;

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getRegionId() {
        return regionId;
    }
}
