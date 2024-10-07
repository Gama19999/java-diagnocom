package ovh.serial30.diagnocom.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.serial30.diagnocom.configuration.Const;
import ovh.serial30.diagnocom.entities.ResultEntity;
import ovh.serial30.diagnocom.exceptions.ServerException;
import ovh.serial30.diagnocom.pojos.dto.*;
import ovh.serial30.diagnocom.pojos.response.ResultResponse;
import ovh.serial30.diagnocom.repositories.ResultRepository;
import ovh.serial30.diagnocom.repositories.UserRepository;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ResultServiceImpl implements ResultService {
    private static final Logger logger = LoggerFactory.getLogger(ResultServiceImpl.class);

    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTService jwtService;

    @Override
    public ResultResponse getResult(String resultId) throws ServerException, JsonProcessingException {
        var resultEnt = resultRepository.findById(UUID.fromString(resultId)).orElseThrow(
                () -> new ServerException(HttpStatus.NOT_FOUND.value(), resultId + Const.Logs.Result.RESULT_NOT_FOUND));
        return getSingleResult(resultEnt);
    }

    @Override
    public List<ResultResponse> getAllResults() throws ServerException, JsonProcessingException {
        var userId = jwtService.getUserId();
        var resultEntList = resultRepository.findByUserId(userId);
        if (resultEntList.isEmpty())
            throw new ServerException(HttpStatus.NO_CONTENT.value(), Const.Logs.Result.EMPTY_RESULTS + userId);
        var allResults = new ArrayList<ResultResponse>();
        for (var resultEnt : resultEntList) allResults.add(getSingleResult(resultEnt));
        return allResults;
    }

    private ResultResponse getSingleResult(ResultEntity resultEnt) throws ServerException, JsonProcessingException {
        var resultContent = resultEnt.getContent();
        var localizacion = getLocalizacion(resultEnt.getContent());
        var generalOptions = switch (localizacion) {
            case Const.BRB.Facts.LOC_CABEZA -> new ObjectMapper().readValue(resultContent, HeadOptions.class);
            case Const.BRB.Facts.LOC_RESPIRATORIA -> new ObjectMapper().readValue(resultContent, RespiratoryOptions.class);
            case Const.BRB.Facts.LOC_DIGESTIVA -> new ObjectMapper().readValue(resultContent, DigestiveOptions.class);
            case Const.BRB.Facts.LOC_INTERNA -> new ObjectMapper().readValue(resultContent, InternalOptions.class);
            case Const.BRB.Facts.LOC_URINARIA -> new ObjectMapper().readValue(resultContent, UrinaryOptions.class);
            case Const.BRB.Facts.LOC_CUTANEA -> new ObjectMapper().readValue(resultContent, SkinOptions.class);
            default -> new ObjectMapper().readValue(resultContent, LocOptions.class);
        };
        var userEnt = userRepository.findById(resultEnt.getUserId()).orElseThrow(
                () -> new ServerException(HttpStatus.NOT_FOUND.value(), Const.Logs.User.USER_NOT_FOUND));
        return new ResultResponse(
                resultEnt.getResultId().toString(), userEnt.getUsername(), generalOptions, resultEnt.getCreatedAt());
    }

    private String getLocalizacion(String content) {
        var localizacion = "";
        var localizaciones = Arrays.asList(
                Const.BRB.Facts.LOC_CABEZA, Const.BRB.Facts.LOC_RESPIRATORIA, Const.BRB.Facts.LOC_DIGESTIVA,
                Const.BRB.Facts.LOC_INTERNA, Const.BRB.Facts.LOC_URINARIA, Const.BRB.Facts.LOC_CUTANEA);
        for (var loc : localizaciones) if (content.contains(loc)) localizacion = loc;
        return localizacion;
    }


    @Override
    @Transactional
    public ResultResponse saveResult(GeneralOptions generalOptions, Map<String, String> data)
            throws JsonProcessingException, ServerException {
        generalOptions.matchUserOptions(data);
        var json = new ObjectMapper().writeValueAsString(generalOptions);
        var entity = new ResultEntity();
        entity.setUserId(jwtService.getUserId());
        entity.setContent(json);
        entity.setCreatedAt(new Timestamp(new Date().getTime()));
        entity = resultRepository.save(entity);
        logger.info(Const.Logs.Result.SAVED_RESULT, entity.getResultId(), entity.getUserId());
        return getSingleResult(entity);
    }
}
