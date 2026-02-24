/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.application.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import pragmafoodcourt.users.domain.model.Role;

/**
 *
 * @author German at CLEZ
 */
@Getter
@Setter
public class UserRequest {
    @NotBlank
    private String name;
    
    @NotBlank
    private String lastName;
    
    @NotBlank
    @Pattern(regexp = "\\d+")
    private String documentNumber;
    
    @NotBlank
    @Pattern(regexp = "\\+?\\d{1,13}")
    private String phoneNumber;
    
    @NotNull
    @Past
    private Instant birthDate;
    
    @NotBlank
    @Email
    private String email;
    
    @NotNull
    private Role role;
}
