package ovh.serial30.diagnocom.services;

import ovh.serial30.diagnocom.exceptions.AuthDataException;
import ovh.serial30.diagnocom.exceptions.ServerException;
import ovh.serial30.diagnocom.pojos.request.UserRequest;
import ovh.serial30.diagnocom.pojos.request.UserUpdateRequest;
import ovh.serial30.diagnocom.pojos.response.UserResponse;
import ovh.serial30.diagnocom.pojos.response.UserToken;

import java.util.UUID;

public interface UserService {
    UserToken registerUser(UserRequest userRequest);

    UserToken loginUser(UserRequest userRequest) throws AuthDataException;

    UserResponse getUser(UUID userId) throws ServerException;

    UserResponse updateUser(UUID userId, UserUpdateRequest userUpdateRequest) throws AuthDataException;
}
