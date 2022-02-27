package com.example.barros_proyect.service;

import com.example.barros_proyect.domain.Cliente;
import com.example.barros_proyect.repository.ClienteRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends BaseService<Cliente, Integer, ClienteRepository> {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente addCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Page<Cliente> getAll(Pageable pageable, @SearchSpec Specification<Cliente> specs){
        return clienteRepository.findAll(specs, pageable);
    }

    public Cliente modifyCliente(Integer id , Cliente cliente) throws Exception {
        if(clienteRepository.findById(id) != null){
            clienteRepository.delete(clienteRepository.getById(id));
           return clienteRepository.save(cliente);
        }
        else{
            throw new Exception("El ID del usuario que se desea modificar no existe");
        }
    }

    public String deleteCliente(Integer id){
        if(clienteRepository.findById(id) != null){
            clienteRepository.deleteById(id);
            return "Cliente borrado. ID: " + id;
        }
        return "El ID del usuario que se desea borrar no existe";
    }

    public Cliente getCliente(Integer id) throws Exception {
        if(clienteRepository.findById(id) != null){
            return clienteRepository.getById(id);
        }else{
            throw new Exception("El ID del usuario que se desea buscar no existe");
        }
    }
}
