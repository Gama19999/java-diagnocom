package com.serial30.diagnocom.controllers;

import com.serial30.diagnocom.configuration.S;
import com.serial30.diagnocom.exceptions.AuthDataException;
import com.serial30.diagnocom.pojos.request.IncomingData;
import com.serial30.diagnocom.pojos.request.UserRequest;
import com.serial30.diagnocom.pojos.response.MessageResponse;
import com.serial30.diagnocom.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(S.Routes.AUTH)
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = S.Routes.REGISTER,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody IncomingData data) {
        var userToken = userService.registerUser(extractData(data));
        var messageResponse = new MessageResponse();
        messageResponse.setStatus(HttpStatus.CREATED.value());
        messageResponse.setData(userToken);
        logger.info("REGISTRATION SUCCESSFUL OF USER ({}) - GENERATED TOKEN ({})", extractData(data).username(), userToken.token());
        return ResponseEntity.status(messageResponse.getStatus()).body(messageResponse);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = S.Routes.LOGIN,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody IncomingData data) throws AuthDataException {
        var userToken = userService.loginUser(extractData(data));
        var messageResponse = new MessageResponse();
        messageResponse.setData(userToken);
        logger.info("AUTH SUCCESSFUL FOR USER ({}) WITH TOKEN ({})", extractData(data).username(), userToken.token());
        return ResponseEntity.status(messageResponse.getStatus()).body(messageResponse);
    }
    
    private UserRequest extractData(IncomingData data) {
        return new UserRequest(data.getObject().get(S.Entities.USERNAME), data.getObject().get(S.Entities.PASSWORD));
    }
}
