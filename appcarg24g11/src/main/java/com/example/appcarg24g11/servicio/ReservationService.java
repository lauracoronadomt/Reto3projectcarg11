package com.example.appcarg24g11.servicio;

import com.example.appcarg24g11.entidad.Reservation;
import com.example.appcarg24g11.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getReservations(){

        return repository.findAll();
    }

    public Reservation saveReservation(Reservation reservation){

        return repository.save(reservation);
    }

    public Reservation getReservation(long id){

        return repository.findById(id).orElse(null);
    }

    public Reservation updateReservation(Reservation reservationUpd){
        Reservation reservationOld = getReservation(reservationUpd.getIdReservation());
        reservationOld.setStartDate(reservationUpd.getStartDate());
        reservationOld.setDevolutionDate(reservationUpd.getDevolutionDate());
        return repository.save(reservationOld);
    }

    public void deleteReservation(long id){

        repository.deleteById(id);
    }
}
