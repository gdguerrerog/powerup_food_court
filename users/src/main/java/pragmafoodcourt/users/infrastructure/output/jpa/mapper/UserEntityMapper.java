/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.infrastructure.output.jpa.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pragmafoodcourt.users.domain.model.User;
import pragmafoodcourt.users.infrastructure.output.jpa.entity.UserEntity;

/**
 *
 * @author German at CLEZ
 */
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    User toUser(UserEntity entity);
    UserEntity toEntity(User user);    
    
    List<User> toUserList(List<UserEntity> entitites);

}
