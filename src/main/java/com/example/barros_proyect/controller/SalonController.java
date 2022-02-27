package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Salon;
import com.example.barros_proyect.service.SalonServiceImpl;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salon")
public class SalonController {

    @Autowired
    SalonServiceImpl salonServiceImpl;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Salon>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                              @SearchSpec Specification<Salon> specs){
        Page<Salon> salones = salonServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(salones, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Salon> addSalon(@RequestBody Salon salon) {
        Salon salonAdd = salonServiceImpl.addSalon(salon);
        return new ResponseEntity<>(salonAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Salon> editSalon(@PathVariable Integer id, @RequestBody Salon newSalon) throws Exception {
        Salon salonMod = salonServiceImpl.modifySalon(id,newSalon);
        return new ResponseEntity<>(salonMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSalon(@PathVariable Integer id){
        return salonServiceImpl.deleteSalon(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Salon> getSalon(@PathVariable Integer id) throws Exception {
        Salon salon = salonServiceImpl.getSalon(id);
        return new ResponseEntity<>(salon,HttpStatus.OK);
    }
}
