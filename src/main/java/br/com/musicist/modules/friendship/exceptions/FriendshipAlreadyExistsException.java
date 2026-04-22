package br.com.musicist.modules.friendship.exceptions;

import br.com.musicist.common.enums.FriendshipStatus;
import br.com.musicist.common.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class FriendshipAlreadyExistsException extends ApiException {
    public FriendshipAlreadyExistsException(FriendshipStatus status) {
        super("Friendship already exists with status: " + status, HttpStatus.CONFLICT);
    }
}
