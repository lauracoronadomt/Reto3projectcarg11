package com.example.appcarg24g11.servicio;

import com.example.appcarg24g11.entidad.Gama;
import com.example.appcarg24g11.repositorio.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamaService {
    @Autowired
    private GamaRepository repository;

    public List<Gama> getGamas(){

        return repository.findAll();
    }
    public Gama saveGama(Gama gama){
        return repository.save(gama);
    }
    public Gama getGama(long id){
        return repository.findById(id).orElse(null);
    }
    public Gama updateGama(Gama gamaUpd){
        Gama gamaOld = getGama(gamaUpd.getIdGama());
        gamaOld.setName(gamaUpd.getName());;
        gamaOld.setDescription(gamaUpd.getDescription());
        return repository.save(gamaOld);
    }

    public void deleteGama(long id){
        repository.deleteById(id);
    }
}
