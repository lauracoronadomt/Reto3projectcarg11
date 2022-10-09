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
@Entity(name="score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idScore;
    private int score;
    private String message;

    /** 1-N Reservation **/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "score")
    @JsonIgnoreProperties("score")
    private List<Reservation> reservations;
}
