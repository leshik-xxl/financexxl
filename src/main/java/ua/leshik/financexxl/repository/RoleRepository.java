package ua.leshik.financexxl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.leshik.financexxl.model.ERole;
import ua.leshik.financexxl.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
