package br.com.delogic.ticketExchange.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.delogic.ticketExchange.domain.User;

@DataJpaTest
public class UserRepositoryTest {
	
	final String TESTNAME = "DELOGIC";
	//final Long USER_ID = (long) 100000;

    @Autowired
    private UserRepository userRepository;
   
   
    @Test
    public void testUserSaveAndFind() {   	
        User newUser = new User();
        newUser.setFirstname(TESTNAME);
        newUser.setLastname(TESTNAME);
        newUser.setUsername(TESTNAME);
        newUser.setEmail("delogic@delogic.com");
        
        userRepository.save(newUser);
        
        //User loaded into Database         
        Optional<User> UserAcquired =  userRepository.findById(newUser.getId());
           
        assertThat(UserAcquired).isPresent();
        assertThat(TESTNAME.equals(UserAcquired.get().getUsername()));
        
    }
}
