package com.masterprogrammer.enigmasimulator;

import android.Manifest;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class EinstellungenActivity extends AppCompatActivity implements Runnable{
    private boolean rotor;
    private ListView listView;
    private WebserverCore webserverCore;
    private RotorHolder rotorHolder;
    private ArrayList<Rotor> rotors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.run();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.einstellungen);
        listView = (ListView)findViewById(R.id.lvObjekte);
        webserverCore = new WebserverCore();
        this.rotor = MainActivity.rotor;
        if(rotor){
            webserverCore.getObject(rotor);
        }else{
            webserverCore.getObject(rotor);
        }

    }
    class DatenHolen extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            //Do whatever you want to do before the network call.
        }

        @Override
        protected String doInBackground(String... params) {
            //Do your call here
            return resultString;
        }

        @Override
        protected void onPostExecute(String result) {
            //Process the result here
        }
    }


    @Override
    public void run() {
        boolean ende = false;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!ende){

            if(PerformNetworkRequest.rotoren != null){
                this.rotors = PerformNetworkRequest.rotoren;
                rotorHolder = new RotorHolder(this, rotors);
                Log.i("I BIMS ", "fsdfdfasfgs");
            }
        }
        Log.i("HHHHHHHHHHHHH ", "fsdfdfasfgs");
    }
}
