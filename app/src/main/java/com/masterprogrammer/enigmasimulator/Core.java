package com.masterprogrammer.enigmasimulator;

import android.util.Log;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Core {
    private Rotor rotor1, rotor2, rotor3;
    private Alphabet alphabet;
    private Plugboard plugboard;
    private Reflektor reflektor;
    private Verschlüsselungsalgorithmus verschlüsselungsalgorithmus;

    public Core(){
        settingsInitialisieren();
        verschlüsselungsalgorithmus = new Verschlüsselungsalgorithmus(rotor1, rotor2, rotor3, reflektor, alphabet, plugboard);
    }
    private void settingsInitialisieren(){
        rotor1 = new Rotor(new String[]{"E","K","M","F","L","G","D","Q","V","Z","N","T","O","W","Y","H","X","U","S","P","A","I","B","R","C","J"}, "Q");
        rotor2 = new Rotor(new String[]{"A","J","D","K","S","I","R","U","X","B","L","H","W","T","M","C","Q","G","Z","N","P","Y","F","V","O","E"}, "E");
        rotor3 = new Rotor(new String[]{"B","D","F","H","J","L","C","P","R","T","X","V","Z","N","Y","E","I","W","G","A","K","M","U","S","Q","O"}, "V");
        reflektor = new Reflektor(new String[]{"Y","R","U","H","Q","S","L","D","P","X","N","G","O","K","M","I","E","B","F","Z","C","W","V","J","A","T"});
        alphabet = new Alphabet();
        plugboard = new Plugboard(alphabet.getAlphabet());
    }

    public String verOderEntschlüsseln(String code){
        code = code.toUpperCase();
        //String[] ary = code.split("");

        String neuerCode = "";
        for(int i = 0; i < code.length(); i++){
            Log.i("Hallo", code.charAt(i) + "bb" );
            neuerCode += verschlüsselungsalgorithmus.verschluesseln(code.charAt(i) + "");
        }
        return neuerCode;
    }
    public Plugboard getPlugboard(){
        return plugboard;
    }
    public Alphabet getAlphabet(){
        return alphabet;
    }
    public Verschlüsselungsalgorithmus getVerschlüsselungsalgorithmus(){
        return verschlüsselungsalgorithmus;
    }
}
