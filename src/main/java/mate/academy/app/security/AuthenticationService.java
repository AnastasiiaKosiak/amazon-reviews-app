package mate.academy.app.security;

import mate.academy.app.entity.User;

public interface AuthenticationService {
    User register(User user);
}
