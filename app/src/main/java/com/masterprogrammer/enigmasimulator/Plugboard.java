package com.masterprogrammer.enigmasimulator;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Plugboard {
    private String[] plugboard;

    public Plugboard(String[] alphabet){
        plugboard = alphabet;
    }

    public String getEntgegengesetzteZahl(int welcheZahlImRotor){
        return plugboard[welcheZahlImRotor];
    }
    public void Zahlenvertauschen(String buchstabe1, String buchstabe2){
        int merken1 = 0, merken2 = 0;
        for (int i = 0; i < plugboard.length; i++){
            if(plugboard[i].equals(buchstabe1)){
                merken1 = i;
            }
            if(plugboard[i].equals(buchstabe2)){
                merken2 = i;
            }
        }
        String placeholder = plugboard[merken1];
        plugboard[merken1] = buchstabe2;
        plugboard[merken2] = placeholder;
    }
}
