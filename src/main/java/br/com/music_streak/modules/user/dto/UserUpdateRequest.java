package br.com.music_streak.modules.user.dto;

public record UserUpdateRequest(String username, String instrument, String bio, Short level) {
}
