package com.masterprogrammer.enigmasimulator;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Reflektor {
    private int ref_id;
    private String[] reflektor;
    private String name;
    private String code;
    public Reflektor(String[] reflektor){
        this.setReflektor(reflektor);
    }

    public Reflektor(int ref_id, String name, String code){
        this.setName(name);
        this.setCode(code);
        this.setRef_id(ref_id);
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

    public void setRef_id(int ref_id) {
        this.ref_id = ref_id;
    }

    public int getRef_id() {
        return ref_id;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
