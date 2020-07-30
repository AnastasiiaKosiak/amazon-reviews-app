package mate.academy.app.service.impl;

import mate.academy.app.entity.Role;
import mate.academy.app.repository.RoleRepository;
import mate.academy.app.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(Role.RoleName roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }
}
