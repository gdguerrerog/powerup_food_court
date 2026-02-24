/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pragmafoodcourt.users.infrastructure.output.jpa.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pragmafoodcourt.users.infrastructure.output.jpa.entity.UserEntity;

/**
 *
 * @author German at CLEZ
 */
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByDocumentNumber(String documentNumber);    
    void deleteUserByDocumentNumber(String documentNumber);    
}
