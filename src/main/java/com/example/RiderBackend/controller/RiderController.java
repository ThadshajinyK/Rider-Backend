package com.example.RiderBackend.controller;

import com.example.RiderBackend.exception.RiderNotFoundException;
import com.example.RiderBackend.model.Rider;
import com.example.RiderBackend.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RiderController{
    @Autowired
    private RiderRepository riderRepository;

    @PostMapping("/addRider")
    Rider newRider(@RequestBody Rider newRider){
        return riderRepository.save(newRider);
    }

    @GetMapping("/riders")
    List<Rider> getAllRiders(){
        return riderRepository.findAll();
    }

    @GetMapping("/rider/{id}")
    Rider getRiderById(@PathVariable Long id){
        return riderRepository.findById(id).orElseThrow(()-> new RiderNotFoundException(id));
    }

    @PutMapping("/rider/{id}")
    Rider updateRider(@RequestBody Rider newRider, @PathVariable Long id){
        return riderRepository.findById(id)
                .map(rider -> {
                    rider.setName(newRider.getName());
                    rider.setEmail(newRider.getEmail());
                    rider.setPosition(newRider.getPosition());
                    rider.setNic(newRider.getNic());
                    rider.setStatus(newRider.getStatus());
                    rider.setImage(newRider.getImage());
return riderRepository.save(rider);
                }).orElseThrow(()->new RiderNotFoundException(id));
    }

    @DeleteMapping("/rider/{id}")
    String deleteRider(@PathVariable Long id){
        if(!riderRepository.existsById(id)){
            throw new RiderNotFoundException(id);
        }
        riderRepository.deleteById(id);
        return "User with id "+id + "has been deleted successfully";
    }
}
