package za.co.user.Factory;

import za.co.user.Domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @org.junit.jupiter.api.Test
    void createUser() {
        User user = UserFactory.createUser("Sifiso@gmail.com", "Sifiso", "Duba","Sifiso123",LocalDate.now(), "Male", "071 444 6184", "143 Sir Lowry Road, Woodstock, Cape Town");
        assertNotNull(user);
        System.out.println(user);
    }
}