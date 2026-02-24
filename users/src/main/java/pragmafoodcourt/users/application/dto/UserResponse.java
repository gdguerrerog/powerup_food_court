/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.application.dto;

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
public class UserResponse {
    private String name;
    private String lastName;
    private String documentNumber;
    private String phoneNumber;
    private Instant birthDate;
    private String email;
    private Role role;
}
