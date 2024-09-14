package com.serial30.diagnocom.services;

import com.serial30.diagnocom.exceptions.AuthDataException;
import com.serial30.diagnocom.pojos.request.UserRequest;
import com.serial30.diagnocom.pojos.response.UserToken;

public interface UserService {
    UserToken registerUser(UserRequest userRequest);

    UserToken loginUser(UserRequest userRequest) throws AuthDataException;
}
