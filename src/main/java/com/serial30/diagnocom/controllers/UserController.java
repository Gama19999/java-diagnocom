package com.serial30.diagnocom.controllers;

import com.serial30.diagnocom.exceptions.AuthDataException;
import com.serial30.diagnocom.pojos.request.IncomingData;
import com.serial30.diagnocom.pojos.request.UserRequest;
import com.serial30.diagnocom.pojos.response.MessageResponse;
import com.serial30.diagnocom.pojos.response.UserResponse;
import com.serial30.diagnocom.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("${app.name}/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(HttpServletRequest request, @RequestBody IncomingData data) {
        var userResponse = userService.registerUser(extractData(data));
        var messageResponse = new MessageResponse();
        messageResponse.setStatus(HttpStatus.CREATED.value());
        messageResponse.setData(userResponse);
        log(request, messageResponse);
        return ResponseEntity.status(messageResponse.getStatus()).body(messageResponse);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "login",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginUser(HttpServletRequest request, @RequestBody IncomingData data) throws AuthDataException {
        var userResponse = userService.loginUser(extractData(data));
        var messageResponse = new MessageResponse();
        messageResponse.setData(userResponse);
        log(request, messageResponse);
        return ResponseEntity.status(messageResponse.getStatus()).body(messageResponse);
    }
    
    private UserRequest extractData(IncomingData data) {
        return new UserRequest(data.getObject().get("username"), data.getObject().get("password"));
    }
    
    private void log(HttpServletRequest request, MessageResponse messageResponse) {
        logger.info("Request from: {}://{}:{}", request.getScheme(), request.getRemoteHost(), request.getRemotePort());
        var data = (UserResponse) messageResponse.getData();
        if (messageResponse.getStatus() == HttpStatus.CREATED.value()) {
            logger.info("Success on registering user ({}) with email ({})", data.username(), data.email());
        } else if (messageResponse.getStatus() == HttpStatus.OK.value()) {
            logger.info("AUTH SUCCESSFUL FOR USER ({})", data.username());
        }
    }
}
