package mate.academy.app.service;

import mate.academy.app.entity.Role;

public interface RoleService {
    Role findByName(Role.RoleName roleName);
}
