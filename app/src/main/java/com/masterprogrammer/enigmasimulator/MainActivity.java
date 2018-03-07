package com.masterprogrammer.enigmasimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Gui gui;
    private Core core;
    private Button[] rotorauswahl, counter;
    private TextView[] rotor;
    private TextView code_ausgabe;
    private Button reflektor;
    private EditText code_eingabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gui = new Gui(this);
        core = new Core();
        //boh
        allesInizialisieren();
        idsZuweisen();
        textViewsTextZuweisen();
    }

    private void allesInizialisieren(){
        //rotoren auswahl
        rotorauswahl = new Button[3];
        for(int i = 0; i < 3; i++){
            rotorauswahl[i] = new Button(this);
            rotorauswahl[i].setOnClickListener(this);
        }
        //counter von Rotoren
        counter = new Button[3];
        for(int i = 0; i < 3; i++){
            counter[i] = new Button(this);
            counter[i].setOnClickListener(this);
        }
        //zahlen aneige
        rotor = new TextView[3];
        for(int i = 0; i < 3; i++){
            rotor[i] = new TextView(this);
        }

        reflektor = new Button(this);
        reflektor.setOnClickListener(this);

        code_ausgabe = new TextView(this);

        code_eingabe = new EditText(this);
    }

    private void idsZuweisen(){
        rotorauswahl[0] = (Button) findViewById(R.id.rotor1_auswahl);
        rotorauswahl[1] = (Button) findViewById(R.id.rotor2_auswahl);
        rotorauswahl[2] = (Button) findViewById(R.id.rotor3_auswahl);

        counter[0] = (Button) findViewById(R.id.rotor_counter1);
        counter[1] = (Button) findViewById(R.id.rotor_counter2);
        counter[2] = (Button) findViewById(R.id.rotor_counter3);

        rotor[0] = (TextView) findViewById(R.id.rotor_text_anzeige1);
        rotor[1] = (TextView) findViewById(R.id.rotor_text_anzeige2);
        rotor[2] = (TextView) findViewById(R.id.rotor_text_anzeige3);

        code_ausgabe = (TextView) findViewById(R.id.code_ausgabe);

        reflektor = (Button) findViewById(R.id.reflektor);

        code_eingabe = (EditText) findViewById(R.id.code_eingabe);
    }

    private void textViewsTextZuweisen(){
        for (int i = 0; i < counter.length; i++){
            rotor[i].setText(core.getRotor(i).getVersciebung());
        }
    }

    @Override
    public void onClick(View v) {
        Object o = findViewById(v.getId());
        if (o == reflektor) {
            //wechseln
        }
        for (int i = 0; i < rotorauswahl.length; i++){
            if(rotorauswahl[i] == o){
                //rotoren wechseln
            }
        }
        for (int i = 0; i < counter.length; i++){
            if(counter[i] == o){
                core.getRotor(i).verschieben();
                rotor[i].setText(core.getRotor(i).getVersciebung());
            }
        }
    }
}
