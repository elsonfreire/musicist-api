package br.com.music_streak.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequestDto {
    @NotBlank(message = "Email is necessary")
    private String email;
    
    @NotBlank(message = "Username is necessary")
    private String username;

    @NotBlank(message = "Password is necessary")
    private String password;
}
