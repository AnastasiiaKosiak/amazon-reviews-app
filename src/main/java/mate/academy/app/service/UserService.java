package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.User;

public interface UserService {
    void add(User user);

    void addAll(List<User> users);

    List<User> findMostActiveUsers(int pageLimit, int offset);
}
