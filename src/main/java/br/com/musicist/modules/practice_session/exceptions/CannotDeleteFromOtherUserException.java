package br.com.musicist.modules.practice_session.exceptions;

import org.springframework.http.HttpStatus;

import br.com.musicist.common.exceptions.ApiException;

public class CannotDeleteFromOtherUserException extends ApiException {
    public CannotDeleteFromOtherUserException() {
        super("You cannot delete another user's practice session", HttpStatus.UNAUTHORIZED);
    }
}
