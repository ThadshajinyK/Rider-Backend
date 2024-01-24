package com.example.RiderBackend.controller;

import com.example.RiderBackend.model.Rider;
import com.example.RiderBackend.repository.RiderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiderController {

    @Autowired
    private RiderRepo riderRepo;

    @PostMapping("/rider")
    Rider newRider(@RequestBody Rider newRider){
        return riderRepo.save(newRider);
    }
}
