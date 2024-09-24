package uz.muydinovs.apprestjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.muydinovs.apprestjwt.payload.LoginDto;
import uz.muydinovs.apprestjwt.security.JwtProvider;
import uz.muydinovs.apprestjwt.service.MyAuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    MyAuthService myAuthService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public HttpEntity<?> loginToSystem(@RequestBody LoginDto loginDto) {
        UserDetails userDetails = myAuthService.loadUserByUsername(loginDto.getUsername());
        boolean existUser = userDetails.getPassword().equals(loginDto.getPassword());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        if (existUser) {
            String token = jwtProvider.generateToken(loginDto.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Username or password is incorrect");
    }
}
