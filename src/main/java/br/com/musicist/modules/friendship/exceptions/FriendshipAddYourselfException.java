package br.com.musicist.modules.friendship.exceptions;

import br.com.musicist.common.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class FriendshipAddYourselfException extends ApiException {
    public FriendshipAddYourselfException() {
        super("You cannot send a friend request to yourself", HttpStatus.BAD_REQUEST);
    }
}
