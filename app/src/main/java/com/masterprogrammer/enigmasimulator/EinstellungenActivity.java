package com.masterprogrammer.enigmasimulator;

import android.Manifest;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class EinstellungenActivity extends AppCompatActivity {
    private RotorHolder rotorHolder;
    private ArrayList<String> name;
    private ArrayList<Reflektor> reflektors;
    private ArrayList<Rotor> rotors;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einstellungen);
        if(PerformNetworkRequest.art.equals("rotor")){
            rotors = PerformNetworkRequest.rotoren;
            name = new ArrayList<>();
            rotorHolder = new RotorHolder(this, name);
            listView = (ListView)findViewById(R.id.lvObjekte);
            listView.setAdapter(rotorHolder);
            for(int i = 0; i < rotors.size();i++){
                rotorHolder.add(rotors.get(i).getName());
                Log.i("BIMMMMMMMMMS", name.get(i) + "");
            }
            rotorHolder.notifyDataSetChanged();
        }
        if(PerformNetworkRequest.art.equals("reflektor")){
            reflektors = PerformNetworkRequest.reflektoren;
            name = new ArrayList<>();
            rotorHolder = new RotorHolder(this, name);
            listView = (ListView)findViewById(R.id.lvObjekte);
            listView.setAdapter(rotorHolder);
            for(int i = 0; i < reflektors.size();i++){
                rotorHolder.add(reflektors.get(i).getName());
                Log.i("BIMMMMMMMMMS", name.get(i) + "");
            }
            rotorHolder.notifyDataSetChanged();
        }


    }
}
