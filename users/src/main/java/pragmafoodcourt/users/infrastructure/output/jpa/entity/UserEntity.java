/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.infrastructure.output.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pragmafoodcourt.users.domain.model.Role;

/**
 *
 * @author German at CLEZ
 */
@Entity
@Table(name =  "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String phoneNumber;
    private Instant birthDate;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
