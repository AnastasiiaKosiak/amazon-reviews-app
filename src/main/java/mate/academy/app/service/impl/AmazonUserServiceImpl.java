package mate.academy.app.service.impl;

import java.util.List;
import mate.academy.app.entity.AmazonUser;
import mate.academy.app.repository.AmazonUserRepository;
import mate.academy.app.service.AmazonUserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AmazonUserServiceImpl implements AmazonUserService {
    private final AmazonUserRepository amazonUserRepository;

    public AmazonUserServiceImpl(AmazonUserRepository amazonUserRepository) {
        this.amazonUserRepository = amazonUserRepository;
    }

    @Override
    public void add(AmazonUser user) {
        amazonUserRepository.save(user);
    }

    @Override
    public void addAll(List<AmazonUser> users) {
        amazonUserRepository.saveAll(users);
    }

    @Override
    public List<AmazonUser> findMostActiveUsers(int pageLimit, int offset) {
        PageRequest pageRequest = PageRequest.of(pageLimit, offset);
        return amazonUserRepository.findAll(pageRequest);
    }
}
