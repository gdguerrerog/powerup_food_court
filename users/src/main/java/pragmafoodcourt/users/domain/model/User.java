/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pragmafoodcourt.users.domain.model;

import java.time.Instant;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author German at CLEZ
 */
@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String phoneNumber;
    private Instant birthDate;
    private String email;
    private String password;
    private Role role;
    
}
