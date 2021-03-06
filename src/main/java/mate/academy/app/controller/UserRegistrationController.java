package mate.academy.app.controller;

import lombok.AllArgsConstructor;
import mate.academy.app.entity.User;
import mate.academy.app.entity.dto.RegistrationDto;
import mate.academy.app.mapper.UserMapper;
import mate.academy.app.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserRegistrationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public void register(@RequestBody RegistrationDto registrationDto) {
        User user = userMapper.convertFromRegistrationDtoToUser(registrationDto);
        authenticationService.register(user);
    }
}
