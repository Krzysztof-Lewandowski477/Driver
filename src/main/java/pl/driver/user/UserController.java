package pl.driver.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-by-id")
    public User getUserById(Long id){
        return userService.getOne(id);
    }

    @GetMapping("/get-by username")
    public User getUserByUsername(String username){
        return userService.getByUsername(username);
    }

    @GetMapping("/get-by-email")
    public User getByEmail(String email){
        return userService.getByEmail(email);
    }
    
    @GetMapping("/userDto")
    public UserDto getUserDto(){
        return new UserDto();
    }

    @PostMapping("/save")
    public void saveUser(UserDto userDto){
        
    }

}
