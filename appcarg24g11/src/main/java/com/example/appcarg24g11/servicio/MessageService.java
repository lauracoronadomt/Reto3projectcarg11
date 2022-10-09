package com.example.appcarg24g11.servicio;

import com.example.appcarg24g11.entidad.Message;
import com.example.appcarg24g11.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public List<Message> getMessages(){

        return repository.findAll();
    }
    public Message saveMessage(Message message){

        return repository.save(message);
    }
    public Message getMessage(long id){

        return repository.findById(id).orElse(null);
    }
    public Message updateMessage(Message messageUpd){
        Message messageOld = getMessage(messageUpd.getIdMessage());
        messageOld.setMessageText(messageUpd.getMessageText());
        return repository.save(messageOld);
    }

    public void deleteMessage(long id) {
        repository.deleteById(id);
    }
}
