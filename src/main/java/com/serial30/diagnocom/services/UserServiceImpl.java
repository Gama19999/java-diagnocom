package com.serial30.diagnocom.services;

import com.serial30.diagnocom.entities.UserEntity;
import com.serial30.diagnocom.exceptions.AuthDataException;
import com.serial30.diagnocom.exceptions.ServerException;
import com.serial30.diagnocom.pojos.request.UserRequest;
import com.serial30.diagnocom.pojos.request.UserUpdateRequest;
import com.serial30.diagnocom.pojos.response.UserResponse;
import com.serial30.diagnocom.pojos.response.UserToken;
import com.serial30.diagnocom.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

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

    private UserEntity extractData(UserRequest userRequest) { // TODO decrypt data
        var entity = new UserEntity();
        entity.setUsername(userRequest.username());
        entity.setPassword(userRequest.password());
        return entity;
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

    @Override
    public UserResponse getUser(UUID userId) throws ServerException {
        var userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()) throw new ServerException("Usuario no encontrado!");
        return exportData(userEntity.get());
    }

    private UserResponse exportData(UserEntity userEntity) {
        return new UserResponse(userEntity.getUsername(), userEntity.getEmail(), userEntity.getLastLogin());
    }

    @Override
    public UserResponse updateUser(UUID userId, UserUpdateRequest userUpdateRequest) throws AuthDataException {
        var userEntity = userRepository.findById(userId).orElseThrow(() -> new AuthDataException("Usuario no encontrado!"));
        if (!userEntity.getPassword().equals(userUpdateRequest.currentPassword()))
            throw new AuthDataException("Constraseña actual erronea!");
        userEntity.setEmail(userUpdateRequest.email());
        userEntity.setLastLogin(new Timestamp(new Date().getTime()));
        if (userUpdateRequest.newPassword() != null) userEntity.setPassword(userUpdateRequest.newPassword());
        userEntity = userRepository.save(userEntity);
        return exportData(userEntity);
    }
}
