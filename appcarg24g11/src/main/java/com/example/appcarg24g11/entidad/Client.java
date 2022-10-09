package com.example.appcarg24g11.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;
    private String name;
    private String email;
    private int age;
    private String password;

    /** N-1 Message **/
    @ManyToOne
    @JoinColumn(name="message_id")
    @JsonIgnoreProperties("clients")
    private Message message;

    /** N-1 Reservation **/
    @ManyToOne
    @JoinColumn(name="reservation_id")
    @JsonIgnoreProperties("clients")
    private Reservation reservation;
}
