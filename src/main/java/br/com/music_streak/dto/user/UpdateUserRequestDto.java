package br.com.music_streak.dto.user;

public record UpdateUserRequestDto(String username, String instrument, String bio, Short level) {
}
