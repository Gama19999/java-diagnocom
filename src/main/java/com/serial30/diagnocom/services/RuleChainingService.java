package com.serial30.diagnocom.services;

import com.serial30.diagnocom.exceptions.FactNotInferredException;

import java.util.ArrayList;
import java.util.Map;

public interface RuleChainingService {
    ArrayList<Object> doForwardChaining(Map<String, String> data) throws FactNotInferredException;
}
