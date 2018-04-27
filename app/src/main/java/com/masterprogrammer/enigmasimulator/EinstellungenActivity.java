package com.masterprogrammer.enigmasimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class EinstellungenActivity extends AppCompatActivity {
    private DatenHalter datenHalter;
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
            datenHalter = new DatenHalter(this, name);
            listView = (ListView)findViewById(R.id.lvObjekte);
            listView.setAdapter(datenHalter);
            for(int i = 0; i < rotors.size();i++){
                datenHalter.add(rotors.get(i).getName());
                Log.i("BIMMMMMMMMMS", name.get(i) + "");
            }
            datenHalter.notifyDataSetChanged();
        }
        if(PerformNetworkRequest.art.equals("reflektor")){
            reflektors = PerformNetworkRequest.reflektoren;
            name = new ArrayList<>();
            datenHalter = new DatenHalter(this, name);
            listView = (ListView)findViewById(R.id.lvObjekte);
            listView.setAdapter(datenHalter);
            for(int i = 0; i < reflektors.size();i++){
                datenHalter.add(reflektors.get(i).getName());
                Log.i("BIMMMMMMMMMS", name.get(i) + "");
            }
            datenHalter.notifyDataSetChanged();
        }


    }
}
