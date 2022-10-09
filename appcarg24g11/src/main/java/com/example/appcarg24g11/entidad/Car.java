package com.example.appcarg24g11.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCar;
    private String name;
    private String brand;
    private String year;
    private String description;

    /** 1-N Gama **/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties("car")
    private List<Gama> gamas;

    /** N-1 Message**/
    @ManyToOne
    @JoinColumn(name="message_id")
    @JsonIgnoreProperties("cars")
    private Message message;

    /** N-1 Reservation**/
    @ManyToOne
    @JoinColumn(name="reservation_id")
    @JsonIgnoreProperties("cars")
    private Reservation reservation;
}
