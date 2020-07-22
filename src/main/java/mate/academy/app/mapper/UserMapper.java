package mate.academy.app.mapper;

import mate.academy.app.entity.AmazonUser;
import mate.academy.app.entity.User;
import mate.academy.app.entity.dto.RegistrationDto;
import mate.academy.app.entity.dto.ReviewDto;
import mate.academy.app.entity.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertFromDtoToUser(ReviewDto dto) {
        User user = new User();
        user.setId(dto.getUserId());
        user.setName(dto.getProfileName());
        return user;
    }

    public UserDto convertFromUserToDto(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        return dto;
    }

    public User convertFromRegistrationDtoToUser(RegistrationDto dto) {
        User user = new User();
        user.setName(dto.getLogin());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserDto convertFromAmazonUserToDto(AmazonUser amazonUser) {
        UserDto dto = new UserDto();
        dto.setName(amazonUser.getName());
        return dto;
    }

    public AmazonUser convertFromDtoToAmazonUser(ReviewDto dto) {
        AmazonUser amazonUser = new AmazonUser();
        amazonUser.setId(dto.getUserId());
        amazonUser.setName(dto.getProfileName());
        return amazonUser;
    }
}
