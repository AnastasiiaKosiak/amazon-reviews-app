package mate.academy.app.repository;

import mate.academy.app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(Role.RoleName roleName);
}
