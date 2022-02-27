package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Usuario;
import com.example.barros_proyect.service.UsuarioServiceImpl;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Usuario>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                @SearchSpec Specification<Usuario> specs){
        Page<Usuario> usuarios = usuarioServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioAdd = usuarioServiceImpl.addUsuario(usuario);
        return new ResponseEntity<>(usuarioAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Usuario> editUsuario(@PathVariable Integer id, @RequestBody Usuario newUsuario) throws Exception {
        Usuario usuarioMod = usuarioServiceImpl.modifyUsuario(id,newUsuario);
        return new ResponseEntity<>(usuarioMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable Integer id){
        return usuarioServiceImpl.deleteUsuario(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id) throws Exception {
        Usuario usuario = usuarioServiceImpl.getUsuario(id);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }
}
