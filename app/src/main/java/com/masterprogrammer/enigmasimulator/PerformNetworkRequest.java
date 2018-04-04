package com.masterprogrammer.enigmasimulator;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

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
    HashMap<String, String> params;

    //get oder post
    int requestCode;

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
            JSONArray daten = new JSONArray(object.getJSONArray("enigma"));
            if (object.getBoolean("error") == false) {
                //Toast.makeText(this, object.getString("message") , Toast.LENGTH_SHORT).show();
                Log.i("Daten", object.getBoolean("error") + "");
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