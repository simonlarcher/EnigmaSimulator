package com.masterprogrammer.enigmasimulator;

import android.text.TextUtils;
import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by Benedikt Smith on 28.03.2018.
 */

public class WebserverCore {

    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    public void createObject(EditText e_name, EditText e_code, EditText e_sprungpunkt){
        boolean rotor = false;
        if(e_sprungpunkt != null){
            rotor = true;
        }
        //inhalt holen
        String name = e_name.getText().toString().trim();
        String code = e_code.getText().toString().trim();
        String sprungpunkt = e_sprungpunkt.getText().toString().trim();

        //ueberpruefen ob code 26 lang ist
        //sprungpunkt darf nur 1 Zeichen sein

        //schauen obs leer ist
        if (TextUtils.isEmpty(name)) {
            e_name.setError("Richtigen Namen eingeben");
            e_name.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(code) && code.length() == 26) {
            e_code.setError("Richtigen Code eingeben");
            e_code.requestFocus();
            return;
        }
        if (rotor){
            if (TextUtils.isEmpty(sprungpunkt)) {
                e_code.setError("Please enter real name");
                e_code.requestFocus();
                return;
            }
        }


        HashMap<String, String> params = new HashMap<>();
        PerformNetworkRequest request;
        if (rotor){
            params.put("name", name);
            params.put("code", code);
            params.put("sprungpunkt", sprungpunkt);
            request = new PerformNetworkRequest(API.URL_CREATE_ROTOR, params, CODE_POST_REQUEST);
        }else{
            params.put("name", name);
            params.put("code", code);
            request = new PerformNetworkRequest(API.URL_CREATE_REFLEKTOR, params, CODE_POST_REQUEST);
        }


        request.execute();
    }
    public void getObject(boolean isItTheRotor){
        if(isItTheRotor){
            PerformNetworkRequest request = new PerformNetworkRequest(API.URL_READ_ROTOR, null, CODE_GET_REQUEST);
            request.execute();
        }else{
            PerformNetworkRequest request = new PerformNetworkRequest(API.URL_READ_REFLEKTOR, null, CODE_GET_REQUEST);
            request.execute();
        }

    }
    private void updateObject(EditText e_name, EditText e_code, EditText e_sprungpunkt, int id) {
        boolean rotor = false;
        if(e_sprungpunkt != null){
            rotor = true;
        }
        String name = e_name.getText().toString().trim();
        String code = e_code.getText().toString().trim();
        String sprungpunkt = e_sprungpunkt.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            e_name.setError("Richtigen Namen eingeben");
            e_name.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(code) && code.length() == 26) {
            e_code.setError("Richtigen Code eingeben");
            e_code.requestFocus();
            return;
        }
        if (rotor){
            if (TextUtils.isEmpty(sprungpunkt)) {
                e_code.setError("Please enter real name");
                e_code.requestFocus();
                return;
            }
        }

        HashMap<String, String> params = new HashMap<>();
        PerformNetworkRequest request;
        if (rotor){
            params.put("name", name);
            params.put("code", code);
            params.put("sprungpunkt", sprungpunkt);
            request = new PerformNetworkRequest(API.URL_UPDATE_ROTOR, params, CODE_POST_REQUEST);
        }else{
            params.put("name", name);
            params.put("code", code);
            request = new PerformNetworkRequest(API.URL_UPDATE_REFLEKTOR, params, CODE_POST_REQUEST);
        }
        request.execute();
    }
    public void deleteObject(int id, boolean isItRotor) {
        if(isItRotor){
            PerformNetworkRequest request = new PerformNetworkRequest(API.URL_DELETE_ROTOR + id, null, CODE_GET_REQUEST);
            request.execute();
        }else{
            PerformNetworkRequest request = new PerformNetworkRequest(API.URL_DELETE_REFLEKTOR + id, null, CODE_GET_REQUEST);
            request.execute();
        }

    }
}
