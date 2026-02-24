/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.infrastructure.input.rest;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pragmafoodcourt.users.application.dto.UserRequest;
import pragmafoodcourt.users.application.dto.UserResponse;
import pragmafoodcourt.users.application.handler.IUserHandler;

/**
 *
 * @author German at CLEZ
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserRestController {
    
    private final IUserHandler userHandler;
    
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid UserRequest request) {
        return userHandler.saveUser(request);
    }  
    
    @GetMapping("")
    public List<UserResponse> getAllUsers() {
        return userHandler.getAllUsers();
    }
    
    @GetMapping("/{document}")
    public UserResponse getUserByDocumentNumber(@PathVariable("document") String document) {
        return userHandler.getUserByDocumentNumber(document);
    }
    
    @PutMapping("")
    public UserResponse getAllUsers(@RequestBody UserRequest request) {
        return userHandler.updateUser(request);
    }
    
    @DeleteMapping("/{document}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("document") String document) {
        userHandler.deleteUserByDocumentNumber(document);
    }
   
    
}
