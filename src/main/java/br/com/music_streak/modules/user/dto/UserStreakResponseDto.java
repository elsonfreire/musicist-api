package br.com.music_streak.modules.user.dto;

public record UserStreakResponseDto(
    Integer currentStreak,
    Integer longestStreak
){}