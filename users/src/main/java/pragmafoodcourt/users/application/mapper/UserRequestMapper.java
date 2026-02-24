/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pragmafoodcourt.users.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pragmafoodcourt.users.application.dto.UserRequest;
import pragmafoodcourt.users.domain.model.User;

/**
 *
 * @author German at CLEZ
 */
@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toUser(UserRequest request);
}
