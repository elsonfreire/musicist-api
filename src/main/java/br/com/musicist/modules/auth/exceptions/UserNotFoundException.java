package br.com.musicist.modules.auth.exceptions;

import org.springframework.http.HttpStatus;

import br.com.musicist.common.exceptions.ApiException;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException() {
        super("User not found", HttpStatus.UNAUTHORIZED);
    }
}
