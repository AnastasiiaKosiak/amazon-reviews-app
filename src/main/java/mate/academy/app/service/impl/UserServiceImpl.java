package mate.academy.app.service.impl;

import java.util.List;
import mate.academy.app.entity.User;
import mate.academy.app.repository.UserRepository;
import mate.academy.app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addAll(List<User> users) {
        userRepository.saveAll(users);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

}
