package pl.driver.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
@Slf4j
public class Username {

    public static String get() {
        return SecurityContextHolder.getContext().getAuthentication().getName();

    }

}
