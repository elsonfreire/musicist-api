package br.com.music_streak.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.music_streak.dto.LoginRequestDto;
import br.com.music_streak.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    // @GetMapping
    // public ResponseEntity<List<User>> getUsers() {
    //     return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    //     User user = userService.findById(id);
        
    //     if(user == null) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     return ResponseEntity.ok(user);
    // }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
    }
    
}
