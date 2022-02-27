package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Evento;
import com.example.barros_proyect.service.EventoServiceImpl;
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
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoServiceImpl eventoServiceImpl;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Evento>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                               @SearchSpec Specification<Evento> specs){
        Page<Evento> eventos = eventoServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Evento> addEvento(@RequestBody Evento evento) {
        Evento eventoAdd = eventoServiceImpl.addEvento(evento);
        return new ResponseEntity<>(eventoAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Evento> editEvento(@PathVariable Integer id, @RequestBody Evento newEvento) throws Exception {
        Evento eventoMod = eventoServiceImpl.modifyEvento(id,newEvento);
        return new ResponseEntity<>(eventoMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvento(@PathVariable Integer id){
        return eventoServiceImpl.deleteEvento(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Evento> getCliente(@PathVariable Integer id) throws Exception {
        Evento evento = eventoServiceImpl.getEvento(id);
        return new ResponseEntity<>(evento,HttpStatus.OK);
    }
}
