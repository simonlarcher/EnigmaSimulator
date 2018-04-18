package com.masterprogrammer.enigmasimulator;

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

    //get oder post
    private int requestCode;

    private ArrayList<Reflektor> reflektoren;
    private ArrayList<Rotor> rotoren;

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
                Log.i("Daten", object.getBoolean("error") + "");
                if(object.getJSONArray("enigma") != null){
                    JSONArray daten = object.getJSONArray("enigma");
                    JSONObject o = daten.getJSONObject(0);
                    Log.i("JSON", daten + "");
                    if(o.getString("art").equals("getRotor")){
                        for(int i = 0; i < daten.length(); i++){
                            JSONObject placeholder = daten.getJSONObject(i);
                            //rotor
                            rotoren.add(new Rotor(placeholder.getString(
                                    "rot_id"),
                                    placeholder.getString("name"),
                                    placeholder.getString("code"),
                                    placeholder.getString("sprungpunkt")
                            ));
                        }
                    }
                    else if(o.getString("art").equals("getReflektor")){

                    }
                    else if(o.getString("art").equals("createRotor")){

                    }
                    else if(o.getString("art").equals("createReflektor")){

                    }
                    else if(o.getString("art").equals("updateRotor")){

                    }else if(o.getString("art").equals("updateReflektor")){

                    }else if(o.getString("art").equals("deleteRotor")){

                    }
                    else if(o.getString("art").equals("deleteReflektor")){

                    }
                    else{
                        for(int i = 0; i < daten.length(); i++){
                            JSONObject placeholder = daten.getJSONObject(i);
                            Log.i("JSON", o.getString("code"));
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