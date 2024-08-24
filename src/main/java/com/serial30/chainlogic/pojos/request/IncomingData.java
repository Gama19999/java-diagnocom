package com.serial30.chainlogic.pojos.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class IncomingData {
    private ArrayList<Boolean> choices;
}
