package br.com.musicist.modules.auth.exceptions;

import org.springframework.http.HttpStatus;

import br.com.musicist.common.exceptions.ApiException;

public class WrongPasswordException extends ApiException {
    public WrongPasswordException() {
        super("Wrong password", HttpStatus.UNAUTHORIZED);
    }
}
