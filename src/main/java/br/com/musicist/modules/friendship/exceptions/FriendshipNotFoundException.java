package br.com.musicist.modules.friendship.exceptions;

import br.com.musicist.common.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class FriendshipNotFoundException extends ApiException {
    public FriendshipNotFoundException() {
        super("Friendship not found", HttpStatus.NOT_FOUND);
    }
}
