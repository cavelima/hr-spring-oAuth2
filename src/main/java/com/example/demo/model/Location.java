package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "locations")
public class Location {
    @Id
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private Integer postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "state_province")
    private String stateProvince;
    @Column(name = "country_id")
    private String countryId;

    public Integer getLocationId() {
        return locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getCountryId() {
        return countryId;
    }
}
