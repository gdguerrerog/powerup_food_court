/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pragmafoodcourt.users.application.handler;

import java.util.List;
import pragmafoodcourt.users.application.dto.UserRequest;
import pragmafoodcourt.users.application.dto.UserResponse;

/**
 *
 * @author German at CLEZ
 */
public interface IUserHandler {
    List<UserResponse> getAllUsers();
    UserResponse getUserByDocumentNumber(String doc);
    UserResponse saveUser(UserRequest user);
    UserResponse updateUser(UserRequest user);
    void deleteUserByDocumentNumber(String doc);
}
