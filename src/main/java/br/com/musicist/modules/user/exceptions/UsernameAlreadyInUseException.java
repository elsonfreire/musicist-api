package br.com.musicist.modules.user.exceptions;

import org.springframework.http.HttpStatus;

import br.com.musicist.common.exceptions.ApiException;

public class UsernameAlreadyInUseException extends ApiException {
    public UsernameAlreadyInUseException() {
        super("Username already in use", HttpStatus.CONFLICT);
    }
}
