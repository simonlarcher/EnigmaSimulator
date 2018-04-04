package com.masterprogrammer.enigmasimulator;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Reflektor {
    private String[] reflektor;
    private String name;
    private String code;
    public Reflektor(String[] reflektor){
        this.setReflektor(reflektor);
    }

    public Reflektor(String name, String code){
        this.setName(name);
        this.setCode(code);
    }

    public String getEntgegengesetzteZahl(int welcheZahlImReflektor){
        return getReflektor()[welcheZahlImReflektor];
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
