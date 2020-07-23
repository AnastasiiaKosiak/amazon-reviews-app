package mate.academy.app.service;

import java.util.List;
import mate.academy.app.entity.AmazonUser;

public interface AmazonUserService {
    void add(AmazonUser user);

    void addAll(List<AmazonUser> users);

    List<AmazonUser> findMostActiveUsers(int pageLimit, int offset);
}
