package pragmafoodcourt.users.application.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pragmafoodcourt.users.application.dto.UserResponse;
import pragmafoodcourt.users.domain.model.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author German at CLEZ
 */
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {
    UserResponse toUserResponse(User user);
}
