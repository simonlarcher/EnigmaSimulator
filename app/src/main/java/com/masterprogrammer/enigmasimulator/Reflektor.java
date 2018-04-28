package com.masterprogrammer.enigmasimulator;

import android.util.Log;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Reflektor {
    private int ref_id;
    private String[] reflektor;
    private String name;
    public Reflektor(String[] reflektor){
        this.setReflektor(reflektor);
    }

    public Reflektor(int ref_id, String name, String code){
        this.setName(name);
        code = code.toUpperCase();


        String[] h = code.split("");
        reflektor = h;
        for (int i = 0; i < h.length; i++){
            if (i == 0){
            }
            else if(i > 0){
                reflektor[i - 1] = h[i];
            }
            else if(i == 26){
            }
        }
        this.setRef_id(ref_id);
    }

    public String getEntgegengesetzteZahl(int welcheZahlImReflektor){
        return reflektor[welcheZahlImReflektor];
    }
    public void setNewEinstellung(String[] einstellung){
        this.setReflektor(einstellung);
    }

    public String[] getReflektor() {
        return reflektor;
    }

    public void setReflektor(String[] reflektor) {
        this.reflektor = reflektor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
    }

    public int getRef_id() {
        return ref_id;
    }

}
