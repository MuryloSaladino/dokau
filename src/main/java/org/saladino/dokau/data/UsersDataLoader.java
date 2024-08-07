package org.saladino.dokau.data;

import org.saladino.dokau.entities.UserDetailsEntity;
import org.saladino.dokau.entities.UserEntity;
import org.saladino.dokau.repositories.UserDetailsRepository;
import org.saladino.dokau.repositories.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UsersDataLoader implements ApplicationRunner {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    public UsersDataLoader(
            BCryptPasswordEncoder encoder,
            UserRepository userRepository,
            UserDetailsRepository userDetailsRepository
    ) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        userRepository.deleteAll();
        userDetailsRepository.deleteAll();

        // ADMIN USER
        userRepository.save(new UserEntity(
                "admin",
                encoder.encode("123456"),
                "admin@mail.com",
                true,
                new UserDetailsEntity("Administrator", "", new Timestamp(1L))
        ));
    }
}
