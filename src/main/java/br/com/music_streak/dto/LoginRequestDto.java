package br.com.music_streak.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
