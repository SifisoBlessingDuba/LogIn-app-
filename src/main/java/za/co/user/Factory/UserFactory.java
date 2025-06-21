package za.co.user.Factory;

import za.co.user.Domain.User;

import java.time.LocalDate;

public class UserFactory {
    public static User createUser(String email, String name, String surname, String password, LocalDate dob, String gender, String phone, String address) {
        return new User.Builder()
                .setEmail(email)
                .setName(name)
                .setSurname(surname)
                .setPassword(password)
                .setDob(dob)
                .setGender(gender)
                .setPhone(phone)
                .setAddress(address)
                .build();
    }
}
