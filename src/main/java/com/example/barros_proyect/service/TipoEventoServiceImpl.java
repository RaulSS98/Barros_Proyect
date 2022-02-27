package com.example.barros_proyect.service;

import com.example.barros_proyect.domain.TipoEvento;
import com.example.barros_proyect.repository.TipoEventoRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TipoEventoServiceImpl {

    @Autowired
    TipoEventoRepository tipoEventoRepository;

    public TipoEvento addTipoEvento(TipoEvento tipoEvento){
        return tipoEventoRepository.save(tipoEvento);
    }

    public Page<TipoEvento> getAll(Pageable pageable, @SearchSpec Specification<TipoEvento> specs){
        return tipoEventoRepository.findAll(specs, pageable);
    }

    public TipoEvento modifyTipoEvento(Integer id , TipoEvento tipoEvento) throws Exception {
        if(tipoEventoRepository.findById(id) != null){
            tipoEventoRepository.delete(tipoEventoRepository.getById(id));
            return tipoEventoRepository.save(tipoEvento);
        }
        else{
            throw new Exception("El ID del tipoevento que se desea modificar no existe");
        }
    }

    public String deleteTipoEvento(Integer id){
        if(tipoEventoRepository.findById(id) != null){
            tipoEventoRepository.deleteById(id);
            return "TipoEvento borrado. ID: " + id;
        }
        return "El ID del tipoevento que se desea borrar no existe.";
    }

    public TipoEvento getTipoEvento(Integer id) throws Exception {
        if(tipoEventoRepository.findById(id) != null){
            return tipoEventoRepository.getById(id);
        }else{
            throw new Exception("El ID del tipoevento que se desea buscar no existe");
        }
    }
}
