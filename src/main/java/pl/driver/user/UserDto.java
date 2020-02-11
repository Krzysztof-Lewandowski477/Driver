package pl.driver.user;

import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String email;
    private String password;
    private String retypedPassword;

}
