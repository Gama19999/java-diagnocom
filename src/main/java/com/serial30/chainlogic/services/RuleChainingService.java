package com.serial30.chainlogic.services;

import com.serial30.chainlogic.exceptions.FactNotInferredException;

import java.util.ArrayList;

public interface RuleChainingService {
    String do1stForwardChaining(ArrayList<Boolean> data) throws FactNotInferredException;

    //String do2ndForwardChaining(ArrayList<Boolean> data) throws FactNotInferredException;
}
