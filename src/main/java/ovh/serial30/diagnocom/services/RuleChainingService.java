package ovh.serial30.diagnocom.services;

import ovh.serial30.diagnocom.exceptions.FactAnalysisException;

import java.util.ArrayList;
import java.util.Map;

public interface RuleChainingService {
    ArrayList<Object> doForwardChaining(Map<String, String> data) throws FactAnalysisException;
}
