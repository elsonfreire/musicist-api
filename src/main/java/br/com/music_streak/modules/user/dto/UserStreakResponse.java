package br.com.music_streak.modules.user.dto;

public record UserStreakResponse(
    Integer currentStreak,
    Integer longestStreak
){}