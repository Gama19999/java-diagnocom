package com.serial30.diagnocom.controllers;

import com.serial30.diagnocom.configuration.S;
import com.serial30.diagnocom.pojos.response.MessageResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(S.Routes.HOME)
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    @RequestMapping(
            method = RequestMethod.GET,
            path = S.Routes.STATUS,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> status(HttpServletRequest request) {
        var response = new MessageResponse();
        response.setData("(" + appName.toUpperCase() + "  v" + appVersion + ") is ACTIVE!");
        log(request, response);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    private void log(HttpServletRequest request, MessageResponse response) {
        logger.info("Request from: {}://{}:{}", request.getScheme(), request.getRemoteHost(), request.getRemotePort());
        logger.info(response.getData().toString());
    }
}
