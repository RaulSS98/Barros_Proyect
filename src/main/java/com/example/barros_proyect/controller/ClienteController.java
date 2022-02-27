package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Cliente;
import com.example.barros_proyect.service.ClienteServiceImpl;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/getAll")
    public ResponseEntity<Page<Cliente>> getAll(@PageableDefault(size = 5, page = 0)Pageable pageable,
                                                @SearchSpec Specification<Cliente> specs){
        Page<Cliente> clientes = clienteServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(clientes,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente clienteAdd = clienteServiceImpl.addCliente(cliente);
        return new ResponseEntity<>(clienteAdd, HttpStatus.OK);
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<Cliente> editCliente(@PathVariable Integer id, @RequestBody Cliente newCliente) throws Exception {
        Cliente clienteMod = clienteServiceImpl.modifyCliente(id,newCliente);
        return new ResponseEntity<>(clienteMod,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCliente(@PathVariable Integer id){
        return clienteServiceImpl.deleteCliente(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Integer id) throws Exception {
        Cliente cliente = clienteServiceImpl.getCliente(id);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }
}
