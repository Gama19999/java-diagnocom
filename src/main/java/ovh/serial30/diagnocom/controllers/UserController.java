package ovh.serial30.diagnocom.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.exceptions.AuthDataException;
import ovh.serial30.diagnocom.exceptions.ServerException;
import ovh.serial30.diagnocom.pojos.request.IncomingData;
import ovh.serial30.diagnocom.pojos.request.UserUpdateRequest;
import ovh.serial30.diagnocom.pojos.response.MessageResponse;
import ovh.serial30.diagnocom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Const.Routes.USER)
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser() throws ServerException {
        var userResponse = userService.getUser();
        var messageResponse = new MessageResponse();
        messageResponse.setData(userResponse);
        logger.info(Const.Logs.User.USER_INFO, userResponse.username());
        return ResponseEntity.status(messageResponse.getStatus()).body(messageResponse);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@RequestBody IncomingData data) throws AuthDataException {
        var userResponse = userService.updateUser(getUserUpdateRequest(data));
        var messageResponse = new MessageResponse();
        messageResponse.setData(userResponse);
        logger.info(Const.Logs.User.USER_UPDATE_INFO, userResponse.username());
        return ResponseEntity.status(messageResponse.getStatus()).body(messageResponse);
    }

    private UserUpdateRequest getUserUpdateRequest(IncomingData data) {
        var user = data.getObject();
        return new UserUpdateRequest(
                user.get(Const.Entities.USERNAME),
                user.get(Const.Entities.EMAIL),
                user.get(Const.Entities.CURRENT_PASSWORD),
                user.get(Const.Entities.NEW_PASSWORD));
    }
}
