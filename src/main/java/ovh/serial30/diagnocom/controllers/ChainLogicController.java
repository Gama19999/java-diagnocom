package ovh.serial30.diagnocom.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.exceptions.FactAnalysisException;
import ovh.serial30.diagnocom.pojos.response.MessageResponse;
import ovh.serial30.diagnocom.pojos.request.IncomingData;
import ovh.serial30.diagnocom.services.RuleChainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Const.Routes.BRB)
public class ChainLogicController {
    private static final Logger logger = LoggerFactory.getLogger(ChainLogicController.class);

    @Autowired
    private RuleChainingService ruleChainingService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = Const.Routes.FORWARD,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doForwardChaining(@RequestBody IncomingData data) throws FactAnalysisException, JsonProcessingException {
        logger.info("Incoming data: \n{}", data.getObject().toString());
        var responseData = ruleChainingService.doForwardChaining(data.getObject());
        var messageResponse = new MessageResponse();
        messageResponse.setData(responseData);
        return ResponseEntity.ok().body(messageResponse);
    }
}
