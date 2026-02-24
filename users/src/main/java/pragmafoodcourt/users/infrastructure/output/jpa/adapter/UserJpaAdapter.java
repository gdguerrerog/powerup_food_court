/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.infrastructure.output.jpa.adapter;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pragmafoodcourt.users.domain.model.User;
import pragmafoodcourt.users.domain.spi.IUserPersistencePort;
import pragmafoodcourt.users.infrastructure.output.jpa.entity.UserEntity;
import pragmafoodcourt.users.infrastructure.output.jpa.exception.UserAlreadyExistsException;
import pragmafoodcourt.users.infrastructure.output.jpa.mapper.UserEntityMapper;
import pragmafoodcourt.users.infrastructure.output.jpa.repository.IUserRepository;

/**
 *
 * @author German at CLEZ
 */
@RequiredArgsConstructor
@Component
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;    
    private final UserEntityMapper userEntityMapper;

    
    @Override
    public List<User> getAllUsers() {
        List<UserEntity> entities = userRepository.findAll();
        return userEntityMapper.toUserList(entities);
    }

    @Override
    public User getUserByDocumentNumber(String documentNumber) {
        Optional<UserEntity> user = userRepository.findByDocumentNumber(documentNumber);
        return user.map(userEntityMapper::toUser).orElseThrow();
    }

    @Override
    public User saveUser(User user) {
        
        Optional<UserEntity> userWithSameDocument = userRepository.findByDocumentNumber(user.getDocumentNumber());
        if (userWithSameDocument.isPresent()) throw new UserAlreadyExistsException();
        
        UserEntity toSave = userEntityMapper.toEntity(user);
        UserEntity saved = userRepository.save(toSave);
        return userEntityMapper.toUser(saved);
    }

    @Override
    public User updateUser(User user) {
        UserEntity toSave = userEntityMapper.toEntity(user);
        UserEntity saved = userRepository.save(toSave);
        return userEntityMapper.toUser(saved);
    }

    @Override
    public void deleteUserByDocumentNumber(String doc) {
        userRepository.deleteUserByDocumentNumber(doc);
    }
    
}
