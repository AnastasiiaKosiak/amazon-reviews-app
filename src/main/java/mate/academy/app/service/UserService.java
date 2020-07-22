package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.User;

public interface UserService {
    User add(User user);

    void addAll(List<User> users);

    User findByName(String name);
}
