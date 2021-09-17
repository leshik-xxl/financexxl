package ua.leshik.financexxl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.leshik.financexxl.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
   User findByLogin(String login);
}
