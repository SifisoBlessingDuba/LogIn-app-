package za.co.user.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class User {
    @Id
    private String email;
    private String name;
    private String surname;
    private String password;
    private LocalDate  dob;
    private String gender;
    private String phone;
    private String address;

    protected User(){

    }
    private User(Builder builder) {
        this.email = builder.email;
        this.name = builder.name;
        this.surname = builder.surname;
        this.password = builder.password;
        this.dob = builder.dob;
        this.gender = builder.gender;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public static class Builder {
        private String email;
        private String name;
        private String surname;
        private String password;
        private LocalDate  dob;
        private String gender;
        private String phone;
        private String address;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setDob(LocalDate dob) {
            this.dob = dob;
            return this;
        }
        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }

}
