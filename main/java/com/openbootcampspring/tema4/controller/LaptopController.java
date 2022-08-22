package com.openbootcampspring.tema4.controller;

import com.openbootcampspring.tema4.entities.Book;
import com.openbootcampspring.tema4.entities.Laptop;
import com.openbootcampspring.tema4.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptop")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        System.out.println(headers.get("Host"));
        laptopRepository.save(laptop);
        return laptopRepository.save(laptop);
    }



}
