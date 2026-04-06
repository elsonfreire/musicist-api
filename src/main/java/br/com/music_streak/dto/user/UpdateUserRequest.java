package br.com.music_streak.dto.user;

public record UpdateUserRequest(String username, String instrument, String bio, Short level) {
}
