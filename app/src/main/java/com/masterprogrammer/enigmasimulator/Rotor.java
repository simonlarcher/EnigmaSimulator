package com.masterprogrammer.enigmasimulator;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Rotor {
    private String[] einstellung;
    private int verschiebung;
    private String sprung;

    public Rotor(String[] einstellung, String sprung){
        this.einstellung = einstellung;
        this.sprung = sprung;
        verschiebung = 0;
    }
    public String getEntgegengesetzteZahl(int welcheZahlImRotor){
        return einstellung[welcheZahlImRotor];
    }
    public int getVersciebung(){
        return verschiebung;
    }
    public void verschieben(){
        verschiebung++;
        if(verschiebung == 26){
            verschiebung = 1;
        }
    }
    public String getSprung(){
        return sprung;
    }
    public String getRotorAusereZahl(String innereBuchstbe, String[] alphabet){
        String code = "";
        for (int i = 0; i < einstellung.length; i++){
            if(getEntgegengesetzteZahl(i).equals(innereBuchstbe)){
                code = alphabet[i];
            }
        }
        return code;
    }
}
