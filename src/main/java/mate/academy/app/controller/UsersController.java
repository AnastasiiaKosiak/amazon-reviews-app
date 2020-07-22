package mate.academy.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.app.entity.dto.UserDto;
import mate.academy.app.mapper.UserMapper;
import mate.academy.app.service.AmazonUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final AmazonUserService amazonUserService;
    private final UserMapper userMapper;

    public UsersController(AmazonUserService amazonUserService, UserMapper userMapper) {
        this.amazonUserService = amazonUserService;
        this.userMapper = userMapper;
    }

    @GetMapping("/most-active")
    public List<UserDto> getMostActiveUsers(@RequestParam int pageLimit, @RequestParam int offset) {
        return amazonUserService.findMostActiveUsers(pageLimit, offset)
                .stream()
                .map(userMapper::convertFromAmazonUserToDto)
                .collect(Collectors.toList());
    }
}
