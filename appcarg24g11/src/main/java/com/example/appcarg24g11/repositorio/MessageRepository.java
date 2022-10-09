package com.example.appcarg24g11.repositorio;

import com.example.appcarg24g11.entidad.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
