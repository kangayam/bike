package com.globomatics.bike.controllers;

import com.globomatics.bike.models.Bike;
import com.globomatics.bike.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/***************************
* Create 3 API end points  *
* 1) List Bikes            *
* 2) Create Bike           *
* 3) Get Bike              *
***************************/

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesControllers {

    @Autowired
    private BikeRepository bikeRepository;

    @RequestMapping
    public List<Bike> list(){
       //List<Bike> bikes = new ArrayList<>();
       //return bikes;
       return bikeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike){
        bikeRepository.save(bike);

    }

    @GetMapping("/{id}")
    public Bike get(@PathVariable("id") long id){
        //return new Bike();
        return bikeRepository.getOne(id);
    }
}
