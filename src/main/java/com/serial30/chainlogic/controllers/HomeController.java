package com.serial30.chainlogic.controllers;

import com.serial30.chainlogic.pojos.response.MessageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("chainlogic")
public class HomeController {

    @Value("${app.name}")
    private String appName;

    @RequestMapping(method = RequestMethod.GET, path = "status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> status() {
        var response = new MessageResponse();
        response.setData(appName.toUpperCase() + " microservice is active!");
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
