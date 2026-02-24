/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    
    public static final String DOCUMENT_PATTERN = "\\d+";    
    public static final String PHONE_PATTERN = "\\+?\\d{1,13}";

    
    @NotBlank
    private String name;
    
    @NotBlank
    private String lastName;
    
    @NotBlank
    @Pattern(regexp = DOCUMENT_PATTERN)
    private String documentNumber;
    
    @NotBlank
    @Pattern(regexp = PHONE_PATTERN)
    private String phoneNumber;
    
    @NotNull
    private LocalDate birthDate;
    
    @NotBlank
    @Email
    private String email;
    
    @NotNull
    private Role role;
    
    @JsonIgnore
    @AssertTrue(message = "User must be at least 18 years old")
    public boolean isAtLeast18Years() {
            
        boolean result =  birthDate == null || birthDate.isBefore(LocalDate.now().minus(18, ChronoUnit.YEARS));
        return result;
    }
}
