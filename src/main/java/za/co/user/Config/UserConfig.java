package za.co.user.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.user.Domain.User;
import za.co.user.Repository.UserRepository;

import java.time.LocalDate;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return args -> {
            // Create user via builder - NOTE: email will NOT be generated, must provide it here.
            User user = new User.Builder()
                    .setEmail("Sifisoblessing75@gmail.com")    // must set manually since @GeneratedValue won't work here
                    .setName("Sifiso")
                    .setSurname("Duba")
                    .setPassword("Sifiso123")
                    .setDob(LocalDate.of(2003, 12, 4))
                    .setGender("Male")
                    .setPhone("0714446284")
                    .setAddress("Cape Town, South Africa")
                    .build();

            // Save user (this may throw exception due to the @GeneratedValue issue on String id)
            userRepository.save(user);

            System.out.println("Test user saved: " + user);
        };
    }
}
