package com.example.appcarg24g11.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    private Date startDate;
    private Date devolutionDate;

    /** 1-N Car **/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private List<Car> cars;

    /** 1-N Client **/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private List<Client> clients;

    /** N-1 Score **/
    @ManyToOne
    @JoinColumn(name="score_id")
    @JsonIgnoreProperties("reservations")
    private Score score;
}
