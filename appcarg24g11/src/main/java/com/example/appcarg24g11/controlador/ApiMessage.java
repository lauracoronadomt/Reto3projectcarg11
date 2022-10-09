package com.example.appcarg24g11.controlador;

import com.example.appcarg24g11.entidad.Message;
import com.example.appcarg24g11.servicio.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*")
public class ApiMessage {
    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> findAllMessage(){
        return service.getMessages();
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable long id){
        return service.getMessage(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveMessage(@RequestBody Message message){
        service.saveMessage(message);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateMessage(@RequestBody Message message){
        service.updateMessage(message);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMessage(@PathVariable long id){
        service.deleteMessage(id);
        return ResponseEntity.status(204).build();
    }
}
