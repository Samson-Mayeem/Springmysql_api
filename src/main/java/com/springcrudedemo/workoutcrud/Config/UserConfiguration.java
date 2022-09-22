package com.springcrudedemo.workoutcrud.Config;
import com.springcrudedemo.workoutcrud.Models.User;
import com.springcrudedemo.workoutcrud.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User Sam = new User(
                    "Sam",
                    "fddc@gmail.com",
                    "43d"
            );
            User Cali = new User(
                    "Cali",
                    "Cali@gmail.com",
                    "43d"
            );
            userRepository.saveAll(List.of(Sam, Cali));
        };
    }
}
