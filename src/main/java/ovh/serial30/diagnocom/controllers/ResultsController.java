package ovh.serial30.diagnocom.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.exceptions.ServerException;
import ovh.serial30.diagnocom.pojos.response.MessageResponse;
import ovh.serial30.diagnocom.services.ResultService;

@RestController
@RequestMapping(Const.Routes.RESULTS)
public class ResultsController {
    private static final Logger logger = LoggerFactory.getLogger(ResultsController.class);

    @Autowired
    private ResultService resultService;

    @RequestMapping(
            method = RequestMethod.GET,
            path = Const.Routes.SINGLE_RESULT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserResult(@PathVariable String resultId) throws ServerException, JsonProcessingException {
        var resultResponse = resultService.getResult(resultId);
        var messageResponse = new MessageResponse();
        messageResponse.setData(resultResponse);
        logger.info(Const.Logs.Result.SINGLE_RESULT, resultId);
        return ResponseEntity.status(messageResponse.getStatus()).body(messageResponse);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUserResults() throws ServerException, JsonProcessingException {
        var resultsResponse = resultService.getAllResults();
        var messageResponse = new MessageResponse();
        messageResponse.setData(resultsResponse);
        logger.info(Const.Logs.Result.ALL_RESULTS, resultsResponse.get(0).username());
        return ResponseEntity.status(messageResponse.getStatus()).body(messageResponse);
    }
}
