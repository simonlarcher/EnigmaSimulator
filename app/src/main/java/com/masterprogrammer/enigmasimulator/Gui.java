package com.masterprogrammer.enigmasimulator;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Gui {
    private MainActivity mainActivity;

    private Button[] rotorauswahl, counter;
    private TextView[] rotor;
    private TextView code_ausgabe;
    private Button reflektor;
    private EditText code_eingabe;

    public Gui(MainActivity mainActivity){
        this.mainActivity = mainActivity;


    }

    public void allesInizialisieren(){
        //rotoren auswahl
        rotorauswahl = new Button[3];
        for(int i = 0; i < 3; i++){

        }
        for(int i = 0; i < 3; i++){

        }
        for(int i = 0; i < 3; i++){

        }
    }


}
