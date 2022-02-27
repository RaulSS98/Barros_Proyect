package com.example.barros_proyect.service;

import com.example.barros_proyect.domain.Usuario;
import com.example.barros_proyect.repository.UsuarioRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario addUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> getAll(Pageable pageable, @SearchSpec Specification<Usuario> specs){
        return usuarioRepository.findAll(specs, pageable);
    }

    public Usuario modifyUsuario(Integer id , Usuario usuario) throws Exception {
        if(usuarioRepository.findById(id) != null){
            usuarioRepository.delete(usuarioRepository.getById(id));
            return usuarioRepository.save(usuario);
        }
        else{
            throw new Exception("El ID del usuario que se desea modificar no existe");
        }
    }

    public String deleteUsuario(Integer id){
        if(usuarioRepository.findById(id) != null){
            usuarioRepository.deleteById(id);
            return "Usuario borrado. ID: " + id;
        }
        return "El ID del usuario que se desea borrar no existe";
    }

    public Usuario getUsuario(Integer id) throws Exception {
        if(usuarioRepository.findById(id) != null){
            return usuarioRepository.getById(id);
        }else{
            throw new Exception("El ID del usuario que se desea buscar no existe");
        }
    }
}
