package com.example.appcarg24g11.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "gama")
public class Gama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGama;
    private String name;
    private  String description;

    /** N-1 car**/
    @ManyToOne
    @JoinColumn(name="car_id")
    @JsonIgnoreProperties("gamas")
    private Car car;
}
