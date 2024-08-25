package com.serial30.chainlogic.services;

import com.serial30.chainlogic.exceptions.FactNotInferredException;

import java.util.Map;

public interface RuleChainingService {
    String doForwardChaining(Map<String, String> data) throws FactNotInferredException;
}
