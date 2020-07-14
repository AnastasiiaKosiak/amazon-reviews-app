package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.User;

public interface UserService {
    void add(User user);

    void addAll(List<User> users);
}
