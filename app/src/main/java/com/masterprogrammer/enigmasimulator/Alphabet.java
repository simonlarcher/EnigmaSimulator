package com.masterprogrammer.enigmasimulator;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Alphabet {
    private final String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public String getBuchstabe(int index){
        return alphabet[index];
    }
    public String[] getAlphabet(){
        return alphabet;
    }
    public int getIndex(String buchstabe){
        int index = 0;
        for (int i = 0; i < alphabet.length; i++){
            if(alphabet[i].equals(buchstabe)){
                index = i;
            }
        }
        return index;
    }
}
