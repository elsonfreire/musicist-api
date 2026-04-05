package br.com.music_streak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.music_streak.dto.user.UserStreakResponseDto;
import br.com.music_streak.model.User;
import br.com.music_streak.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/streak")
    public ResponseEntity<UserStreakResponseDto> getUserStreak(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        UserStreakResponseDto streakDto = new UserStreakResponseDto(
            user.getCurrentStreak(),
            user.getLongestStreak()
        );

        return ResponseEntity.ok(streakDto);
    }

}
