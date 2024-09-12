package com.serial30.diagnocom.services;

import com.serial30.diagnocom.entities.UserEntity;
import com.serial30.diagnocom.exceptions.AuthDataException;
import com.serial30.diagnocom.pojos.request.UserRequest;
import com.serial30.diagnocom.pojos.response.UserResponse;
import com.serial30.diagnocom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        var userEntity = userRepository.save(extractData(userRequest));
        return exportData(userEntity);
    }

    @Override
    public UserResponse loginUser(UserRequest userRequest) throws AuthDataException {
        var userEntity = userRepository.findByUsername(userRequest.username());
        if (!userRequest.password().equals(userEntity.getPassword())) throw new AuthDataException("Wrong password!");
        userEntity.setLastLogin(new Timestamp(new Date().getTime()));
        userEntity = userRepository.save(userEntity);
        return exportData(userEntity);
    }

    private UserEntity extractData(UserRequest userRequest) { // TODO decrypt data
        var entity = new UserEntity();
        entity.setUsername(userRequest.username());
        entity.setPassword(userRequest.password());
        return entity;
    }

    private UserResponse exportData(UserEntity userEntity) { // TODO encrypt data
        return new UserResponse(
                userEntity.getUserId().toString(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getLastLogin()
        );
    }
}
