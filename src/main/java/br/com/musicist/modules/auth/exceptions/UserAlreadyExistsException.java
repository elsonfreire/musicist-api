package br.com.musicist.modules.auth.exceptions;

import org.springframework.http.HttpStatus;

import br.com.musicist.common.exceptions.ApiException;

public class UserAlreadyExistsException extends ApiException {
    public UserAlreadyExistsException(String conflictingField) {
        super("User already exists with this " + conflictingField, HttpStatus.CONFLICT);
    }
}
