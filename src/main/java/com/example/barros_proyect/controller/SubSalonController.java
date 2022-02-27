package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.SubSalon;
import com.example.barros_proyect.service.SubSalonServiceImpl;
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
@RequestMapping("/subSalon")
public class SubSalonController {

    @Autowired
    SubSalonServiceImpl subSalonServiceImpl;

    @GetMapping("/getAll")
    public ResponseEntity<Page<SubSalon>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                 @SearchSpec Specification<SubSalon> specs){
        Page<SubSalon> subSalones = subSalonServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(subSalones, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SubSalon> addSubSalon(@RequestBody SubSalon subSalon) {
        SubSalon subSalonAdd = subSalonServiceImpl.addSubSalon(subSalon);
        return new ResponseEntity<>(subSalonAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<SubSalon> editEvento(@PathVariable Integer id, @RequestBody SubSalon newSubSalon) throws Exception {
        SubSalon subSalonMod = subSalonServiceImpl.modifySubSalon(id,newSubSalon);
        return new ResponseEntity<>(subSalonMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSubSalon(@PathVariable Integer id){
        return subSalonServiceImpl.deleteSubSalon(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SubSalon> getSubSalon(@PathVariable Integer id) throws Exception {
        SubSalon subSalon = subSalonServiceImpl.getSubsalon(id);
        return new ResponseEntity<>(subSalon,HttpStatus.OK);
    }
}
