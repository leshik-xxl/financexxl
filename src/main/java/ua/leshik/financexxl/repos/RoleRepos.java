package ua.leshik.financexxl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.leshik.financexxl.model.ERole;
import ua.leshik.financexxl.model.Role;

import java.util.Optional;

@Repository
public interface RoleRepos extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
