package mate.academy.app.security;

import java.util.Set;
import mate.academy.app.entity.Role;
import mate.academy.app.entity.User;
import mate.academy.app.service.RoleService;
import mate.academy.app.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder encoder;
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(PasswordEncoder encoder,
                                     UserService userService,
                                     RoleService roleService) {
        this.encoder = encoder;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Set.of(roleService.findByName(Role.RoleName.USER)));
        return userService.add(user);
    }
}
