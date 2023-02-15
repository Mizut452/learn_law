package Mizut452;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DoPasswordEncode {
    public static void main(String[] args) {

        System.out.println(passwordEncoder().encode("topAccount255"));
        System.out.println(passwordEncoder().encode("secondAccount362"));
    }

    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
