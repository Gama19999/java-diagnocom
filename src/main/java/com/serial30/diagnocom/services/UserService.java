package com.serial30.diagnocom.services;

import com.serial30.diagnocom.exceptions.AuthDataException;
import com.serial30.diagnocom.pojos.request.UserRequest;
import com.serial30.diagnocom.pojos.response.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);

    UserResponse loginUser(UserRequest userRequest) throws AuthDataException;
}
