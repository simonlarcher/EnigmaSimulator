package com.masterprogrammer.enigmasimulator;

import android.util.Log;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Rotor {
    private String[] einstellung;
    private int verschiebung, rot_id;
    private String sprung, name, einstellungen;

    public Rotor(String name, String[] einstellung, String sprung){
        this.name = name;
        this.einstellung = einstellung;
        this.sprung = sprung;
        verschiebung = 0;
    }
    public Rotor(String[] einstellung, String sprung){
        this.einstellung = einstellung;
        this.sprung = sprung;
    }
    public Rotor(String rot_id, String name, String einstellung, String sprung){
        this.rot_id = Integer.parseInt(rot_id);
        this.name = name;
        einstellung = einstellung.toUpperCase();
        this.einstellung = einstellung.split("");
        this.sprung = sprung;
        verschiebung = 0;
        String[] h =  einstellung.split("");
        for (int i = 0; i < h.length; i++){  //length = 27
            if (i == 0){
            }
            else if(i > 0){
                this.einstellung[i - 1] = h[i];

            }
            else if(i == 26){
            }

        }
        for (int i = 0;i < this.einstellung.length; i++){
            Log.i("mmmmmmmmmmmmm" , this.einstellung[i] + " " + i);
        }

    }
    public String getEntgegengesetzteZahl(int welcheZahlImRotor){
        return einstellung[welcheZahlImRotor];
    }
    public int getVersciebung(){
        return verschiebung;
    }
    public void setVerschiebung(int verschiebung){
        this.verschiebung = verschiebung;
    }
    public void verschieben(){
        verschiebung++;
        if(verschiebung == 26){
            verschiebung = 0;
        }
    }
    public String getSprung(){
        return sprung;
    }
    public String getName(){return name;}
    public String getEinstellung(){return einstellungen;}
    public void setEinstellung(String einstellung){
        this.einstellungen = einstellung;
    }
    public void setName(String Name){
        this.name = name;
    }
    public void setSprung(String sprung){
        this.sprung = sprung;
    }
    public String getRotorAusereZahl(String innereBuchstbe, String[] alphabet){
        String code = "";
        for (int i = 0; i < 26; i++){
            if(getEntgegengesetzteZahl(i).equals(innereBuchstbe)){
                code = alphabet[i];
            }
        }
        return code;
    }
    public void setEinstellung(String[] einstellung, String sprung){
        this.einstellung = einstellung;
        this.sprung = sprung;
    }
}
