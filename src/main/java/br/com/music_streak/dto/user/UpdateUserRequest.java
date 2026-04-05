package br.com.music_streak.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
    private String username;
    private String instrument;
    private String bio;
    private Short level;
}
