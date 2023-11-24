package com.mikko.mmback.controllers;

import com.mikko.mmback.entities.Campaigns;
import com.mikko.mmback.repos.CampaignRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CampaignController {

    @Autowired
    CampaignRepository CRepo;

    @GetMapping("/")
    public String getHello() {
        return "hello";
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/campaigns")
    public List<Campaigns> getCampaigns() {
        List<Campaigns> campaigns = CRepo.findAll();
        return campaigns;
    }
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PostMapping("/campaigns")
    public ResponseEntity<Campaigns> createCampaign(@RequestBody Campaigns campaigns) {
        Campaigns savedCampaign = CRepo.save(campaigns);
        return ResponseEntity.ok(savedCampaign);
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @PutMapping("/campaigns/{id}")
    public ResponseEntity<Campaigns> updateCampaign( @RequestBody Campaigns updatedCampaign, @PathVariable int id
    ) {
        Campaigns existingCampaign = CRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found"));

        if (existingCampaign == null) {
            return ResponseEntity.notFound().build();
        }

        // Kopioi päivitetyt kentät olemassaolevaan kampanjaan
        BeanUtils.copyProperties(updatedCampaign, existingCampaign, "id");

        // Tallenna päivitetty kampanja tietokantaan
        Campaigns savedCampaign = CRepo.save(existingCampaign);

        return ResponseEntity.ok(savedCampaign);
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @DeleteMapping("/campaigns/{id}")
    public ResponseEntity<Campaigns> deleteCampaign(@PathVariable("id") int id) {
        System.out.println("deleting");
        try {
            CRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
