package pl.driver.user;

public interface UserService {
    Long getUserId();

    User getOne(Long id);

    User getByUsername(String username);

    User getByEmail(String email);
}
