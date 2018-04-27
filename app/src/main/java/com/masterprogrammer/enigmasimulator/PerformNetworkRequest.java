package com.masterprogrammer.enigmasimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benedikt Smith on 28.03.2018.
 */

public class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;
    //url wo die anfrage geschickt wird
    private String url;

    //die Daten
    private HashMap<String, String> params;

    public static String art;
    public PerformNetworkRequest(){

    }

    //get oder post
    private int requestCode;

    public static ArrayList<Reflektor> reflektoren;
    public static ArrayList<Rotor> rotoren;

    PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
        this.url = url;
        this.params = params;
        this.requestCode = requestCode;
    }

    //when the task started displaying a progressbar
    /*@Override
    protected void onPreExecute() {
        super.onPreExecute();
    }*/


    //gibt die Antworten zurück
    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);
        Log.i("DATEN", s + "");
        try {
            JSONObject object = new JSONObject(s);
            if (object.getBoolean("error") == false) {
                //Toast.makeText(this, object.getString("message") , Toast.LENGTH_SHORT).show();
                //Log.i("Daten", object.getBoolean("error") + "");
                if(object.getJSONArray("enigma") != null){
                    JSONArray daten = object.getJSONArray("enigma");
                    Log.i("JSON", daten + "");
                    if(object.getString("art").equals("getRotor")){
                        this.rotoren = new ArrayList<>();
                        art = "rotor";
                        for(int i = 0; i < daten.length(); i++){
                            JSONObject placeholder = daten.getJSONObject(i);
                            Log.i("JSON", placeholder.getString("sprungpunkt") + "");
                            //rotor
                            String rot_id= placeholder.getString("rot_id");
                            String name = placeholder.getString("name");
                            String code = placeholder.getString("code");
                            String sprungpunkt = placeholder.getString("sprungpunkt");
                            rotoren.add(new Rotor(rot_id, name, code, sprungpunkt));
                        }
                        Log.i("BIMS","BIMS");
                        //Intent i = new Intent(MainActivity.mainActivity, EinstellungenActivity.class);
                        MainActivity.mainActivity.startEinstellungsactivity();

                    }
                    else if(object.getString("art").equals("getReflektor")){
                        this.reflektoren = new ArrayList<>();
                        art = "reflektor";
                        for(int i = 0; i < daten.length(); i++){
                            JSONObject placeholder = daten.getJSONObject(i);
                            Log.i("JSON", placeholder.getString("code") + "");
                            //rotor
                            int ref_id= placeholder.getInt("ref_id");
                            String name = placeholder.getString("name");
                            String code = placeholder.getString("code");
                            reflektoren.add(new Reflektor(ref_id, name, code));
                        }
                        Log.i("BIMS","BIMS");
                        //Intent i = new Intent(MainActivity.mainActivity, EinstellungenActivity.class);
                        MainActivity.mainActivity.startEinstellungsactivity();
                    }
                    else if(object.getString("art").equals("createRotor")){

                    }
                    else if(object.getString("art").equals("createReflektor")){

                    }
                    else if(object.getString("art").equals("updateRotor")){

                    }else if(object.getString("art").equals("updateReflektor")){

                    }else if(object.getString("art").equals("deleteRotor")){

                    }
                    else if(object.getString("art").equals("deleteReflektor")){

                    }
                    else{
                        for(int i = 0; i < daten.length(); i++){
                            JSONObject placeholder = daten.getJSONObject(i);
                            Log.i("JSON", object.getString("code"));
                        }
                    }
                }
            }
            else{
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //the network operation will be performed in background
    @Override
    protected String doInBackground(Void... voids) {
        RequestHandler requestHandler = new RequestHandler();

        if (requestCode == CODE_POST_REQUEST)
            return requestHandler.sendPostRequest(url, params);


        if (requestCode == CODE_GET_REQUEST)
            return requestHandler.sendGetRequest(url);

        return null;
    }

}