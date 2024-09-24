package uz.muydinovs.apprestjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyAuthService implements UserDetailsService {

    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = new ArrayList<>(
                Arrays.asList(
                        new User("user", passwordEncoder.encode("user"), new ArrayList<>()),
                        new User("admin", passwordEncoder.encode("admin"), new ArrayList<>()),
                        new User("director", passwordEncoder.encode("director"), new ArrayList<>())
                ));

        for (User user : userList) {
            if (user.getUsername().equals(username))
                return user;

        }
        throw new UsernameNotFoundException("User not found ");
    }
}
