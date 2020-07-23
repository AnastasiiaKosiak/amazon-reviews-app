package mate.academy.app.entity.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String login;
    private String password;
    private String repeatedPwd;
}
