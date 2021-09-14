package ua.leshik.financexxl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.leshik.financexxl.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String eMail);
}
