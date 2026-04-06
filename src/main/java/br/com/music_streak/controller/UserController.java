package br.com.music_streak.controller;

import java.util.List;

import br.com.music_streak.dto.user.UpdateUserRequestDto;
import br.com.music_streak.dto.user.UserResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.music_streak.dto.user.UserStreakResponseDto;
import br.com.music_streak.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long id) {
        UserResponseDto user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/streak")
    public ResponseEntity<UserStreakResponseDto> getUserStreak(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getStreak(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserRequestDto userDetails) {
        return ResponseEntity.ok(userService.update(id, userDetails));
    }
}
