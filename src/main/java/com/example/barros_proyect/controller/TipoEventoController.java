package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.TipoEvento;
import com.example.barros_proyect.service.TipoEventoServiceImpl;
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
@RequestMapping("/tipoEvento")
public class TipoEventoController {

    @Autowired
    TipoEventoServiceImpl tipoEventoServiceImpl;

    @GetMapping("/getAll")
    public ResponseEntity<Page<TipoEvento>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                   @SearchSpec Specification<TipoEvento> specs){
        Page<TipoEvento> tipoEvento = tipoEventoServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(tipoEvento, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TipoEvento> addTipoEvento(@RequestBody TipoEvento tipoEvento) {
        TipoEvento tipoEventoAdd = tipoEventoServiceImpl.addTipoEvento(tipoEvento);
        return new ResponseEntity<>(tipoEventoAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<TipoEvento> editTipoEvento(@PathVariable Integer id, @RequestBody TipoEvento newTipoEvento) throws Exception {
        TipoEvento tipoEventoMod = tipoEventoServiceImpl.modifyTipoEvento(id,newTipoEvento);
        return new ResponseEntity<>(tipoEventoMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTipoEvento(@PathVariable Integer id){
        return tipoEventoServiceImpl.deleteTipoEvento(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TipoEvento> getTipoEvento(@PathVariable Integer id) throws Exception {
        TipoEvento tipoEvento = tipoEventoServiceImpl.getTipoEvento(id);
        return new ResponseEntity<>(tipoEvento,HttpStatus.OK);
    }
}
