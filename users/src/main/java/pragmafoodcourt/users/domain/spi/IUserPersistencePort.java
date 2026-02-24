/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package pragmafoodcourt.users.domain.spi;

import java.util.List;
import pragmafoodcourt.users.domain.model.User;

/**
 *
 * @author German at CLEZ
 */
public interface IUserPersistencePort {
    List<User> getAllUsers();
    User getUserByDocumentNumber(String doc);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUserByDocumentNumber(String doc);
}
