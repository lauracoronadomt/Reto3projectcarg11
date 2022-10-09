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
@Entity(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMessage;
    private String messageText;

    /** 1-N Car **/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "message")
    @JsonIgnoreProperties("message")
    private List<Car> cars;

    /** 1-N Client **/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "message")
    @JsonIgnoreProperties("message")
    private List<Client> clients;
}
