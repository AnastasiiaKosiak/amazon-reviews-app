package mate.academy.app.mapper;

import mate.academy.app.entity.User;
import mate.academy.app.entity.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User convertFromDtoToUser(ReviewDto dto) {
        User user = new User();
        user.setId(dto.getUserId());
        user.setName(dto.getProfileName());
        return user;
    }
}
