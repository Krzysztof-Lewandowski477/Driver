package pl.driver.user;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.driver.role.RoleRepository;
import pl.driver.score.Score;
import pl.driver.utils.Username;

import java.util.Arrays;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public DefaultUserService(UserRepository userRepository, ModelMapper mapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Long getUserId() {
        return userRepository.getByUsername(Username.get()).getId();
    }

    @Override
    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public void saveUser(UserDto userDto){
        User user = mapper.map(userDto, User.class);
        user.setActive(false);
        Score score = new Score();
        score.setScore(0);
        user.setScore(score);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.getByName("ROLE_USER")));
    }

}
