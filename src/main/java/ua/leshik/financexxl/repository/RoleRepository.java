package ua.leshik.financexxl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.leshik.financexxl.model.ERole;
import ua.leshik.financexxl.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(ERole role);
}