package com.serial30.diagnocom.services;

import com.serial30.diagnocom.entities.UserEntity;
import com.serial30.diagnocom.exceptions.AuthDataException;
import com.serial30.diagnocom.pojos.request.UserRequest;
import com.serial30.diagnocom.pojos.response.UserToken;
import com.serial30.diagnocom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;

    @Override
    public UserToken registerUser(UserRequest userRequest) {
        var userId = userRepository.save(extractData(userRequest)).getUserId().toString();
        var token = jwtService.generateToken(userId);
        return new UserToken(token);
    }

    @Override
    public UserToken loginUser(UserRequest userRequest) throws AuthDataException {
        var userEntity = userRepository.findByUsername(userRequest.username());
        if (userEntity == null) throw new AuthDataException("Usuario no encontrado!");
        if (!userRequest.password().equals(userEntity.getPassword())) throw new AuthDataException("Autenticación fallida!");
        userEntity.setLastLogin(new Timestamp(new Date().getTime()));
        userEntity = userRepository.save(userEntity);
        var token = jwtService.generateToken(userEntity.getUserId().toString());
        return new UserToken(token);
    }

    private UserEntity extractData(UserRequest userRequest) { // TODO decrypt data
        var entity = new UserEntity();
        entity.setUsername(userRequest.username());
        entity.setPassword(userRequest.password());
        return entity;
    }
}
