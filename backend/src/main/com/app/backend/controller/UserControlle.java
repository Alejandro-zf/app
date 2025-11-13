package com.app.backend.controller;

import com.app.backend.model.User;
import com.app.backend.service.UserService;
import com.app.backend.dto.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.Http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")

public class UserController {
    
    @Autowired
    private UserService userservice;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN', 'COORDINADOR')")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userservice.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN', 'COORDINADOR')")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userservice.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userservice.create(user));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        return ResponseEntity.ok(userservice.update(id, user));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('COORDINADOR')")
    public ResponseEntity<User> updateMyProfile(@PathVariable Long id, @RequestBody User user, Authentication authentication){
        try{
            return ResponseEntity.ok(userservice.update(id, user));
        } catch (RuntimeException e){
            return ResponseEntity.status(403).build();
        }
    }

    @PutMapping("/{id}")
@PreAuthorize("hasRole('COORDINADOR')")
public ResponseEntity<User> updateMyProfile(@PathVariable Long id, @RequestBody User user, Authentication authentication){
    Long authenticatedUserId = ((UserDetailsImpl) authentication.getPrincipal()).getId();
    if (!authenticatedUserId.equals(id)) {
        return ResponseEntity.status(403).build();
    }
    try {
        return ResponseEntity.ok(userservice.update(id, user));
    } catch (RuntimeException e) {
        return ResponseEntity.status(403).build();
    }
}


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> deleteUser(@PathVariable Long id) {
        userservice.delete(id);
        return ResponseEntity.ok(new MessageResponse("Usuario eliminado con éxito"));
    }   
}