package com.serial30.diagnocom.services;

import com.serial30.diagnocom.exceptions.AuthDataException;
import com.serial30.diagnocom.exceptions.ServerException;
import com.serial30.diagnocom.pojos.request.UserRequest;
import com.serial30.diagnocom.pojos.request.UserUpdateRequest;
import com.serial30.diagnocom.pojos.response.UserResponse;
import com.serial30.diagnocom.pojos.response.UserToken;

import java.util.UUID;

public interface UserService {
    UserToken registerUser(UserRequest userRequest);

    UserToken loginUser(UserRequest userRequest) throws AuthDataException;

    UserResponse getUser(UUID userId) throws ServerException;

    UserResponse updateUser(UUID userId, UserUpdateRequest userUpdateRequest) throws AuthDataException;
}
