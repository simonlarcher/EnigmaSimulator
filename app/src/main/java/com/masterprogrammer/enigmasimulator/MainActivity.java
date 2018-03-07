package com.masterprogrammer.enigmasimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Gui gui;
    private Core core;
    private Button[] b_rotorauswahl, b_counter;
    private TextView[] tv_rotor;
    private TextView tv_code_ausgabe;
    private Button b_reflektor, b_umwandeln;
    private EditText et_code_eingabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gui = new Gui(this);
        core = new Core();


        //Gui

        allesInizialisieren();

        textViewsTextZuweisen();
    }

    private void allesInizialisieren(){
        //rotoren auswahl
        b_rotorauswahl = new Button[3];
        b_rotorauswahl[0] = (Button) findViewById(R.id.b_rotor1_auswahl);
        b_rotorauswahl[1] = (Button) findViewById(R.id.b_rotor2_auswahl);
        b_rotorauswahl[2] = (Button) findViewById(R.id.b_rotor3_auswahl);
        for(int i=0; i<b_rotorauswahl.length; i++){
            ((Button)b_rotorauswahl[i]).setOnClickListener(this);
        }

        //counter von Rotoren
        b_counter = new Button[3];
        b_counter[0] = (Button) findViewById(R.id.b_rotor_counter1);
        b_counter[1] = (Button) findViewById(R.id.b_rotor_counter2);
        b_counter[2] = (Button) findViewById(R.id.b_rotor_counter3);
        for(int i = 0; i < b_counter.length; i++) {
            b_counter[i].setOnClickListener(this);
        }
        //zahlen aneige
        tv_rotor = new TextView[3];
        tv_rotor[0] = (TextView) findViewById(R.id.tv_rotor_text_anzeige1);
        tv_rotor[1] = (TextView) findViewById(R.id.tv_rotor_text_anzeige2);
        tv_rotor[2] = (TextView) findViewById(R.id.tv_rotor_text_anzeige3);


        //b_umwandeln = new Button(this);
        b_umwandeln = (Button) findViewById(R.id.b_umwandeln);
        b_umwandeln.setOnClickListener(this);

        //b_reflektor = new Button(this);
        b_reflektor = (Button) findViewById(R.id.b_reflektor);
        b_reflektor.setOnClickListener(this);

        tv_code_ausgabe = (TextView) findViewById(R.id.tv_code_ausgabe);

        et_code_eingabe = (EditText) findViewById(R.id.et_code_eingabe);
    }

    private void textViewsTextZuweisen(){
        for (int i = 0; i < tv_rotor.length; i++){
            tv_rotor[i].setText(core.getRotor(i).getVersciebung() + "");
        }
    }

    @Override
    public void onClick(View v) {


        Object o = findViewById(v.getId());
        if (o == b_reflektor) {
            //wechseln
        }
        if(o == b_umwandeln){
            String code= core.verOderEntschlüsseln("a");
            tv_code_ausgabe.setText(code);
            textViewsTextZuweisen();
        }
        for (int i = 0; i < b_rotorauswahl.length; i++){
            if(b_rotorauswahl[i] == o){
                //rotoren wechseln
            }
        }
        for (int i = 0; i < b_counter.length; i++){
            if(b_counter[i] == o){
                core.getRotor(i).verschieben();
                tv_rotor[i].setText(core.getRotor(i).getVersciebung() + "");
            }
        }
    }
}
