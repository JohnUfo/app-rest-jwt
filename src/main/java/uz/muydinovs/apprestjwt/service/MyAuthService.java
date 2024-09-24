package uz.muydinovs.apprestjwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyAuthService implements UserDetailsService {

    List<User> userList = new ArrayList<>(
            Arrays.asList(
                    new User("user", "user", new ArrayList<>()),
                    new User("admin", "admin", new ArrayList<>()),
                    new User("director", "director", new ArrayList<>())
            ));

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (User user : userList) {
            if (user.getUsername().equals(username))
                return user;

        }
        throw new UsernameNotFoundException("User not found ");
    }
}
