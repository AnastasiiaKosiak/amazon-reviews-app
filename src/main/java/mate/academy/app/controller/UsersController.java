package mate.academy.app.controller;


import mate.academy.app.entity.dto.UserDto;
import mate.academy.app.mapper.UserMapper;
import mate.academy.app.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UsersController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/most-active")
    public List<UserDto> getMostActiveUsers(@RequestParam int pageLimit, @RequestParam int offset) {
        return userService.findMostActiveUsers(pageLimit, offset)
                .stream()
                .map(userMapper::convertFromUserToDto)
                .collect(Collectors.toList());
    }
}
