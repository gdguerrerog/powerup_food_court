/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pragmafoodcourt.users.domain.usecase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pragmafoodcourt.users.domain.api.IUserServicePort;
import pragmafoodcourt.users.domain.spi.IUserPersistencePort;

/**
 *
 * @author German at CLEZ
 */
class UserUserCaseTest {

    private static IUserPersistencePort persistencePort; 
    
    @BeforeAll()
    public static void setupPersistencePort() {
    }
    
    
    @Test
    public void crearUsuarioTest() {
        IUserServicePort userUseCase = new UserUseCase(null);
    }
    
}
