package com.masterprogrammer.enigmasimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        listView = (ListView)findViewById(R.id.lvObjekte);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(PerformNetworkRequest.art.equals("rotor")){
                    rotors = PerformNetworkRequest.rotoren;
                    int rotor = MainActivity.mainActivity.getWelcherRotor();
                    MainActivity.mainActivity.getCore().getVerschlüsselungsalgorithmus().setRotor(rotor, rotors.get(position));
                }
                else if(PerformNetworkRequest.art.equals("reflektor")){
                    reflektors = PerformNetworkRequest.reflektoren;
                    MainActivity.mainActivity.getCore().getVerschlüsselungsalgorithmus().setReflektor(reflektors.get(position));
                    //String[] h = MainActivity.mainActivity.getCore().getVerschlüsselungsalgorithmus().getReflektor().getReflektor();
                    //for (int i = 0; i < h.length; i++){
                     //   Log.i("mmmmmmmmmmmm" ,  h[i]);
                    //}

                }

            }
        });
        if(PerformNetworkRequest.art.equals("rotor")){
            rotors = PerformNetworkRequest.rotoren;
            name = new ArrayList<>();
            datenHalter = new DatenHalter(this, name);
            listView.setAdapter(datenHalter);
            for(int i = 0; i < rotors.size();i++){
                datenHalter.add(rotors.get(i).getName());
            }
            datenHalter.notifyDataSetChanged();
        }
        else if(PerformNetworkRequest.art.equals("reflektor")){
            reflektors = PerformNetworkRequest.reflektoren;
            name = new ArrayList<>();
            datenHalter = new DatenHalter(this, name);
            listView.setAdapter(datenHalter);
            for(int i = 0; i < reflektors.size();i++){
                datenHalter.add(reflektors.get(i).getName());
            }
            datenHalter.notifyDataSetChanged();
        }


    }
}
