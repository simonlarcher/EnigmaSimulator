package com.masterprogrammer.enigmasimulator;

/**
 * Created by Benedikt Smith on 28.03.2018.
 */

public class API {

    private static final String ROOT_URL = "http://simonlarcher.bplaced.net/enigmasimulator/api.php?apicall=";

    public static final String URL_CREATE_ROTOR = ROOT_URL + "createRotor";
    public static final String URL_CREATE_REFLEKTOR = ROOT_URL + "createReflektor";
    public static final String URL_READ_ROTOR = ROOT_URL + "getRotor";
    public static final String URL_READ_REFLEKTOR = ROOT_URL + "getReflektor";
    public static final String URL_UPDATE_ROTOR = ROOT_URL + "updateRotor";
    public static final String URL_UPDATE_REFLEKTOR = ROOT_URL + "updateReflektor";
    public static final String URL_DELETE_ROTOR = ROOT_URL + "deleteRotor&rot_id=";
    public static final String URL_DELETE_REFLEKTOR = ROOT_URL + "deleteRotor&ref_id=";

}
