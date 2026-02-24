/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.application.handler;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pragmafoodcourt.users.application.dto.UserRequest;
import pragmafoodcourt.users.application.dto.UserResponse;
import pragmafoodcourt.users.application.mapper.UserRequestMapper;
import pragmafoodcourt.users.application.mapper.UserResponseMapper;
import pragmafoodcourt.users.domain.api.IUserServicePort;
import pragmafoodcourt.users.domain.model.User;

/**
 *
 * @author German at CLEZ
 */
@Service
@RequiredArgsConstructor
public class UserHandler implements IUserHandler {

    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final IUserServicePort userServicePort;
    
    @Override
    public List<UserResponse> getAllUsers() {
        return userServicePort.getAllUsers().stream().map(userResponseMapper::toUserResponse).toList();
    }

    @Override
    public UserResponse getUserByDocumentNumber(String doc) {
        User user = userServicePort.getUserByDocumentNumber(doc);
        return userResponseMapper.toUserResponse(user);
    }

    @Override
    public UserResponse saveUser(UserRequest user) {
        User mapped = userRequestMapper.toUser(user);
        User saved = userServicePort.saveUser(mapped);
        return userResponseMapper.toUserResponse(saved);
    }

    @Override
    public UserResponse updateUser(UserRequest user) {

        User u = userServicePort.getUserByDocumentNumber(user.getDocumentNumber());
        u.setName(user.getName());            
        u.setLastName(user.getLastName());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        
        User saved = userServicePort.updateUser(u);
        return userResponseMapper.toUserResponse(saved);
        
    }

    @Override
    public void deleteUserByDocumentNumber(String doc) {
        User u = userServicePort.getUserByDocumentNumber(doc);
        userServicePort.deleteUserByDocumentNumber(u.getDocumentNumber());
    }
    
}
