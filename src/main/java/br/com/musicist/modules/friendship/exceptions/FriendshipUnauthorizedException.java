package br.com.musicist.modules.friendship.exceptions;

import br.com.musicist.common.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class FriendshipUnauthorizedException extends ApiException {
    public FriendshipUnauthorizedException() {
        super("Only the receiver can accept this request", HttpStatus.FORBIDDEN);
    }
}
