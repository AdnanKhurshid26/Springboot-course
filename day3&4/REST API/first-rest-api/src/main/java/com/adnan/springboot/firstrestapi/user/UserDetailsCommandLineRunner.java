package com.adnan.springboot.firstrestapi.user;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

    private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    private UserDetailsRepository userDetailsRepository;

    public UserDetailsCommandLineRunner(UserDetailsRepository userDetailsRepository) {
        super();
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
            userDetailsRepository.save(new UserDetails("Adnan", "Admin"));
            userDetailsRepository.save(new UserDetails("James", "User"));
            userDetailsRepository.save(new UserDetails("Lars", "Admin"));
    }
    
}
