package com.example.barros_proyect.service;

import com.example.barros_proyect.domain.Salon;
import com.example.barros_proyect.repository.SalonRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SalonServiceImpl {


    @Autowired
    SalonRepository salonRepository;

    public Salon addSalon(Salon salon){
        return salonRepository.save(salon);
    }

    public Page<Salon> getAll(Pageable pageable, @SearchSpec Specification<Salon> specs){
        return salonRepository.findAll(specs, pageable);
    }

    public Salon modifySalon(Integer id , Salon salon) throws Exception {
        if(salonRepository.findById(id) != null){
            salonRepository.delete(salonRepository.getById(id));
            return salonRepository.save(salon);
        }
        else{
            throw new Exception("El ID del salon que se desea modificar no existe");
        }
    }

    public String deleteSalon(Integer id){
        if(salonRepository.findById(id) != null){
            salonRepository.deleteById(id);
            return "Salon borrado. ID: " + id;
        }
        return "El ID del salon que se desea borrar no existe";
    }

    public Salon getSalon(Integer id) throws Exception {
        if(salonRepository.findById(id) != null){
            return salonRepository.getById(id);
        }else{
            throw new Exception("El ID del salon que se desea buscar no existe");
        }
    }
}
