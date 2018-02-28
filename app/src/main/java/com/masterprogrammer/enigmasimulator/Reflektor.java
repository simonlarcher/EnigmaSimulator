package com.masterprogrammer.enigmasimulator;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Reflektor {
    private String[] reflektor;

    public Reflektor(String[] reflektor){
        this.reflektor = reflektor;
    }
    public String getEntgegengesetzteZahl(int welcheZahlImReflektor){
        return reflektor[welcheZahlImReflektor];
    }
}
