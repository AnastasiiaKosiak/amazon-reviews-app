package mate.academy.app.controller;

import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.app.entity.User;
import mate.academy.app.entity.dto.LoginDto;
import mate.academy.app.security.AuthenticationService;
import mate.academy.app.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserLoginController {
    private final AuthenticationService authenticationService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDto dto) {
        User user = authenticationService.login(dto.getName(),
                dto.getPassword());
        String token = jwtUtil.createToken(user.getName(),
                user.getRoles()
                        .stream()
                        .map(role -> role.getRoleName().name())
                        .collect(Collectors.toList()));
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
