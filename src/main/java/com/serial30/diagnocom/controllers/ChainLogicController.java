package com.serial30.diagnocom.controllers;

import com.serial30.diagnocom.exceptions.FactNotInferredException;
import com.serial30.diagnocom.pojos.response.MessageResponse;
import com.serial30.diagnocom.pojos.request.IncomingData;
import com.serial30.diagnocom.services.RuleChainingService;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("${app.name}")
public class ChainLogicController {

    private static final Logger logger = LoggerFactory.getLogger(ChainLogicController.class);

    @Autowired
    private RuleChainingService ruleChainingService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "forward",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doForwardChaining(HttpServletRequest request, @RequestBody IncomingData data) throws FactNotInferredException {
        logRequestData(request);
        var responseData = ruleChainingService.doForwardChaining(data.getChoices());
        var messageResponse = new MessageResponse();
        messageResponse.setData(responseData);
        return ResponseEntity.ok().body(messageResponse);
    }

    private void logRequestData(HttpServletRequest request) {
        logger.info("Request from: {}://{}:{}", request.getScheme(), request.getRemoteHost(), request.getRemotePort());
        logger.info("To: {}://{}:{}{}", request.getScheme(), request.getServerName(), request.getServerPort(), request.getRequestURI());
    }
}
