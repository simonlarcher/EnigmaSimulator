package com.masterprogrammer.enigmasimulator;

/**
 * Created by Benedikt Smith on 28.02.2018.
 */

public class Verschlüsselungsalgorithmus {
    private Rotor rotor1, rotor2, rotor3;
    private Alphabet alphabet;
    private Plugboard plugboard;
    private Reflektor reflektor;


    public Verschlüsselungsalgorithmus(){
        rotor1 = new Rotor(new String[]{"E","K","M","F","L","G","D","Q","V","Z","N","T","O","W","Y","H","X","U","S","P","A","I","B","R","C","J"}, "Q");
        rotor2 = new Rotor(new String[]{"A","J","D","K","S","I","R","U","X","B","L","H","W","T","M","C","Q","G","Z","N","P","Y","F","V","O","E"}, "E");
        rotor3 = new Rotor(new String[]{"B","D","F","H","J","L","C","P","R","T","X","V","Z","N","Y","E","I","W","G","A","K","M","U","S","Q","O"}, "V");
        reflektor = new Reflektor(new String[]{"Y","R","U","H","Q","S","L","D","P","X","N","G","O","K","M","I","E","B","F","Z","C","W","V","J","A","T"});
        alphabet = new Alphabet();
        plugboard = new Plugboard(alphabet.getAlphabet());
    }
    public String verschluesseln(String buchstabe){
        String code = "";

        int index1 = alphabet.getIndex(buchstabe);

        //Plugboard
        //code = plugboard.getEntgegengesetzteZahl(index1);
        //System.out.println(" " + code+ " ");
        //rotor1
        //verschiebung von rotor1 berechnen
        if (index1 + rotor1.getVersciebung() >= 26){
            index1 = (index1 + rotor1.getVersciebung()) - 26;
        }
        else{
            index1+= rotor1.getVersciebung();
        }
        code = rotor1.getEntgegengesetzteZahl(index1);

        //Rotor2
        //verschiebng rotor1 berechnen
        int index2 = alphabet.getIndex(code);
        index2 = verSchiebungRotorBerechnen(rotor1, index2);

        //verschiebung rotor2 berechnen
        code = rotorInnerenBuchstabenBerechnen(rotor2, index2);
        code = rotor2.getEntgegengesetzteZahl(index2);

        //Rotor3
        int index3 = alphabet.getIndex(code);
        //verschiebung rotor2 berechnen
        index3 = verSchiebungRotorBerechnen(rotor2, index3);

        //verschiebung rotor3 berechnen
        code = rotorInnerenBuchstabenBerechnen(rotor3, index3);
        code = rotor3.getEntgegengesetzteZahl(index3);

        //index 4 definieren
        int index4 = alphabet.getIndex(code);

        //code für Spiegelung berechnen
        code = rotorInnerenBuchstabenBerechnen(rotor3, index4);
        code = rotor3.getEntgegengesetzteZahl(index3);

        //Spiegelung
        int index5 = alphabet.getIndex(code);
        index5 = verSchiebungRotorBerechnen(rotor3, index5);
        //gespiegelte Zahl berechnen
        code = reflektor.getEntgegengesetzteZahl(index5);

        //zurück Rotor3
        int index6 = alphabet.getIndex(code);

        //Rotor3 inneren Buchstaben berechnen dann ausere zahl definieren
        code = rotorInnerenBuchstabenBerechnen(rotor3, index6);
        code = rotor3.getRotorAusereZahl(code, alphabet.getAlphabet());

        //zurück Rotor2
        int index7 = alphabet.getIndex(code);

        //verschiebng rotor3 berechnen
        index7 = verSchiebungRotorBerechnen(rotor3, index7);

        //verschiebung rotor2 berechnen
        code = rotorInnerenBuchstabenBerechnen(rotor2, index7);
        code = rotor2.getRotorAusereZahl(code, alphabet.getAlphabet());

        //zurück rotor1
        int index8 = alphabet.getIndex(code);
        index8 = verSchiebungRotorBerechnen(rotor2, index8);

        code = rotorInnerenBuchstabenBerechnen(rotor1, index8);
        code = rotor1.getRotorAusereZahl(code, alphabet.getAlphabet());

        //Plugboard
        int index9 = alphabet.getIndex(code);

        //rotor1 mitberechnen
        index9 = verSchiebungRotorBerechnen(rotor1, index9);
        code = alphabet.getBuchstabe(index9);

        //code = plugboard.getEntgegengesetzteZahl(index9);

        //rotor1 verschieben
        rotor1.verschieben();

        //rotor 2 verschieben
        int verschiebung = rotor1.getVersciebung();

        if(alphabet.getBuchstabe(verschiebung).equals(rotor1.getSprung())){
            rotor2.verschieben();
            //System.out.println("Sprung");
        }
        verschiebung = rotor2.getVersciebung();

        //rotor3 verschieben
        if(alphabet.getBuchstabe(verschiebung).equals(rotor2.getSprung())){
            rotor3.verschieben();
        }
        return code;
    }
    private int verSchiebungRotorBerechnen(Rotor rotor, int index){
        if(index - rotor.getVersciebung()< 0){
            int zahl = index-rotor.getVersciebung();
            index =  26 + zahl;
        }
        else{
            index -= rotor.getVersciebung();
        }
        return index;
    }
    private String rotorInnerenBuchstabenBerechnen(Rotor rotor, int index){
        String code = "";
        if (index +  rotor.getVersciebung() >= 26){
            index = (index + rotor.getVersciebung()) - 26;
            code = alphabet.getBuchstabe(index);
        }
        else{
            index += rotor.getVersciebung();
            code = alphabet.getBuchstabe(index);
        }
        return code;
    }
}
