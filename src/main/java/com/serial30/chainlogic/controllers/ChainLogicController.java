package com.serial30.chainlogic.controllers;

import com.serial30.chainlogic.exceptions.FactNotInferredException;
import com.serial30.chainlogic.pojos.response.MessageResponse;
import com.serial30.chainlogic.pojos.request.IncomingData;
import com.serial30.chainlogic.services.RuleChainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("chainlogic")
public class ChainLogicController {

    @Autowired
    private RuleChainingService ruleChainingService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "forward",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doForwardChain(@RequestBody IncomingData data) throws FactNotInferredException {
        var fact = ruleChainingService.do1stForwardChaining(data.getChoices());
        var response = new MessageResponse();
        response.setData(fact);
        return ResponseEntity.ok().body(response);
    }
}
