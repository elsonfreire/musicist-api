package br.com.music_streak.dto.user;

public record UserStreakResponseDto(
    Integer currentStreak,
    Integer longestStreak
){}