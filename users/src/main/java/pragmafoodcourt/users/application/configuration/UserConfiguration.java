/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pragmafoodcourt.users.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pragmafoodcourt.users.domain.api.IUserServicePort;
import pragmafoodcourt.users.domain.spi.IUserPersistencePort;
import pragmafoodcourt.users.domain.usecase.UserUseCase;

/**
 *
 * @author German at CLEZ
 */
@Configuration
public class UserConfiguration {
        
    @Bean
    public IUserServicePort iUserServicePort(IUserPersistencePort persistencePort) {
        return new UserUseCase(persistencePort);
    }
    
}
