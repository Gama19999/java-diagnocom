package com.serial30.diagnocom.controllers;

import com.serial30.diagnocom.configuration.S;
import com.serial30.diagnocom.exceptions.FactNotInferredException;
import com.serial30.diagnocom.pojos.response.MessageResponse;
import com.serial30.diagnocom.pojos.request.IncomingData;
import com.serial30.diagnocom.services.RuleChainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(S.Routes.BRB)
public class ChainLogicController {

    @Autowired
    private RuleChainingService ruleChainingService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = S.Routes.FORWARD,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doForwardChaining(@RequestBody IncomingData data) throws FactNotInferredException {
        var responseData = ruleChainingService.doForwardChaining(data.getObject());
        var messageResponse = new MessageResponse();
        messageResponse.setData(responseData);
        return ResponseEntity.ok().body(messageResponse);
    }
}
