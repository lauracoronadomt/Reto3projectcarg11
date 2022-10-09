package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Gama;
import co.usa.ciclo3.ciclo3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll(){
        return gamaRepository.getAll();
    }

    public Optional<Gama> getGama(int id){
        return gamaRepository.getGama(id);
    }

    public Gama save(Gama gama){
        if(gama.getIdGama()==null){
            return gamaRepository.save(gama);
        }else{
            Optional<Gama> Gamaauxiliar=gamaRepository.getGama(gama.getIdGama());
            if(Gamaauxiliar.isEmpty()){
                return gamaRepository.save(gama);
            }else{
                return gama;
            }
        }
    }
}
