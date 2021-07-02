package de.mkccl.communityprojectbackend.auth.user.exception;

/**
 * Created by
 * User: Michael Krause
 * Date: 14.06.21
 * Time: 11:58
 */

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String userId) {
        super(String.format("User not with the ID: %s not found", userId));
    }

}
