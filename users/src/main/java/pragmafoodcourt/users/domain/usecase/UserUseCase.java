/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.domain.usecase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import pragmafoodcourt.users.domain.api.IUserServicePort;
import pragmafoodcourt.users.domain.model.User;
import pragmafoodcourt.users.domain.spi.IUserPersistencePort;

/**
 *
 * @author German at CLEZ
 */
@RequiredArgsConstructor
public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistentPort;
    
    @Override
    public List<User> getAllUsers() {
        return userPersistentPort.getAllUsers();
    }

    @Override
    public User getUserByDocumentNumber(String documentNumber) {
        return userPersistentPort.getUserByDocumentNumber(documentNumber);
    }

    @Override
    public User saveUser(User user) {
        return userPersistentPort.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userPersistentPort.updateUser(user);
  }

    @Override
    public void deleteUserByDocumentNumber(String doc) {
        userPersistentPort.deleteUserByDocumentNumber(doc);
     }
    
}
