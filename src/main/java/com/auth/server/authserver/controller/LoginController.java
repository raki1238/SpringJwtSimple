package com.auth.server.authserver.controller;

import com.auth.server.authserver.model.ApiToken;
import com.auth.server.authserver.model.Client;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/loginme")
public class LoginController {

    @PostMapping
    public ResponseEntity<ApiToken> login(@RequestBody Client client){
        System.out.println("In login controller");
        return new ResponseEntity<>(
                new ApiToken(Jwts.builder().setSubject(client.getClientName()).claim("roles", "user")
                        .setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "27*%$09aju#").compact())
        ,HttpStatus.OK);
    }
}
