package com.serial30.diagnocom.controllers;

import com.serial30.diagnocom.pojos.response.MessageResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("${app.name}")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${app.name}")
    private String appName;

    @RequestMapping(method = RequestMethod.GET, path = "status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> status(HttpServletRequest request) {
        logRequestData(request);
        var response = new MessageResponse();
        response.setData(appName.toUpperCase() + " microservice is active!");
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    private void logRequestData(HttpServletRequest request) {
        logger.info("Request from: {}://{}:{}", request.getScheme(), request.getRemoteHost(), request.getRemotePort());
        logger.info("To: {}://{}:{}{}", request.getScheme(), request.getServerName(), request.getServerPort(), request.getRequestURI());
    }
}
