package com.serial30.chainlogic.pojos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class IncomingData {
    private Map<String, String> choices;
}
