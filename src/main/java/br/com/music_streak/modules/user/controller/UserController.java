package br.com.music_streak.modules.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.music_streak.modules.user.dto.UserUpdateRequest;
import br.com.music_streak.modules.user.dto.UserResponse;
import br.com.music_streak.modules.user.dto.UserStreakResponse;
import br.com.music_streak.modules.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long id) {
        UserResponse user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/streak")
    public ResponseEntity<UserStreakResponse> getUserStreak(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getStreak(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateRequest userDetails) {
        return ResponseEntity.ok(userService.update(id, userDetails));
    }
}
