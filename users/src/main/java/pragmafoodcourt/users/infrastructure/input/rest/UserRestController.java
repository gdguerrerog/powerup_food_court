/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.infrastructure.input.rest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
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
    @Operation(summary = "Create a user")
    public UserResponse createUser(@RequestBody @Valid UserRequest request) {
        return userHandler.saveUser(request);
    }  
    
    @GetMapping("")
    @Operation(summary = "Get all users")
    public List<UserResponse> getAllUsers() {
        return userHandler.getAllUsers();
    }
    
    @GetMapping("/{document}")
    @Operation(summary = "Get user by document")
    public UserResponse getUserByDocumentNumber(@PathVariable("document") @Pattern(regexp = UserRequest.DOCUMENT_PATTERN) String document) {
        return userHandler.getUserByDocumentNumber(document);
    }
    
    @PutMapping("")
    @Operation(summary = "Update user")
    public UserResponse updateUser(@RequestBody @Valid UserRequest request) {
        return userHandler.updateUser(request);
    }
    
    @DeleteMapping("/{document}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete user by document")
    public void deleteUser(@PathVariable("document") @Pattern(regexp = UserRequest.DOCUMENT_PATTERN) String document) {
        userHandler.deleteUserByDocumentNumber(document);
    }
   
    
}
