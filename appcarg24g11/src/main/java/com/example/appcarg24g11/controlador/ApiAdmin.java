package com.example.appcarg24g11.controlador;

import com.example.appcarg24g11.entidad.Admin;
import com.example.appcarg24g11.servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")
public class ApiAdmin {
    @Autowired
    private AdminService service;

    @GetMapping("/all")
    public List<Admin> findAllAdmin(){
        return service.getAdmints();
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable long id){
        return service.getAdmin(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveAdmin(@RequestBody Admin admin){
        service.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody Admin admin){
        service.updateAdmin(admin);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable long id){
        service.deleteAdmin(id);
        return ResponseEntity.status(204).build();
    }
}
