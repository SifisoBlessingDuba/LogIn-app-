package za.co.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.user.Domain.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User save (User user);

    void deleteById(String email);

    Optional<User> findById(String email);

    List<User> findAll();
}
