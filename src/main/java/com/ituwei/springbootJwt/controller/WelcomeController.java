package com.ituwei.springbootJwt.controller;


import com.ituwei.springbootJwt.model.AuthRequest;
import com.ituwei.springbootJwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

        @Autowired
        private JwtUtil jwtUtil;

        @Autowired
        private AuthenticationManager authenticManager;

    @GetMapping("/")
    public String welcome(){
        return "you made it!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{
    try{    authenticManager.authenticate (
                new UsernamePasswordAuthenticationToken( authRequest.getUsername(),authRequest.getPassword())
        );}
    catch(Exception ex){
        throw new Exception("invalid Credentials");
    }
    return jwtUtil.generateToken(authRequest.getUsername());
    }
}
