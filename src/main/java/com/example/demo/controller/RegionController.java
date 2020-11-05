package com.example.demo.controller;


import com.example.demo.model.Region;
import com.example.demo.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/regions/")
public class RegionController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping(value="/all")
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @CrossOrigin(allowCredentials = "true")
    @GetMapping(value="/{id}")
    public ResponseEntity<Region> getByRegionId(@PathVariable("id") Integer regionId) {
        Optional<Region> regionOptional = regionRepository.findById(regionId);
        if (!regionOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Region region = regionOptional.get();
        return ResponseEntity.ok(region);
    }

    @CrossOrigin
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            path="/add")
    ResponseEntity<Region> Region(@RequestBody Region region) {
        regionRepository.save(region);
        return ResponseEntity.ok(region);
    }

    @CrossOrigin
    @PutMapping(path = "/update/{id}")
    ResponseEntity<Region> updateRegion(@RequestBody Region region, @PathVariable("id") Integer regionId) {
        Optional<Region> regionOptional = this.regionRepository.findById(regionId);
        if (!regionOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        region.setRegionId(regionId);
        regionRepository.save(region);

        return ResponseEntity.ok(region);
    }

    @CrossOrigin
    @DeleteMapping(path = "/delete/{id}")
    void deleteRegion(@PathVariable("id") Integer regionId) {
        regionRepository.deleteById(regionId);
    }
}
