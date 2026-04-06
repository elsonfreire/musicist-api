package br.com.music_streak.infra.security;

import br.com.music_streak.modules.user.model.User;

public interface TokenService {
    public String generateToken(User user);
    public String validateToken(String token);
}
