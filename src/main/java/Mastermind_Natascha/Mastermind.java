package Mastermind_Natascha;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    private static char[] buchstaben = {'r', 'g', 'b', 'y', 's', 'w'};
    private static char[] geheimcode = new char[4];
    private static char[] eingabe = new char[4];
    private static int zählerAllesRichtig = 0;
    private static int zählerPosRichtig = 0;

    public static void main(String[] args) {

        // Am Anfang bestimmt der Computer einen zufälligen, vierstelligen Geheimcode aus
        //sechs zur Verfügung stehenden Farben.
        Random zufall = new Random();
        for (int i = 0; i < 4; i++) {
            int zufallszahl = zufall.nextInt(6);
            geheimcode[i] = buchstaben[zufallszahl];
        }
        System.out.println(geheimcode);

        // Spieler aufgefordert den Geheimcode zu erraten und einen eigenen Code
        //einzugeben.
        System.out.println("Geben Sie einen Versuchscode mit vier Buchstaben aus der Menge " + "{'r', 'g', 'b', 'y', 's', 'w'}" + " ein: ");

        //Solange nicht alle 4 richtig erraten wurden: Werte eingeben
        while (zählerAllesRichtig < 4) {
            zählerAllesRichtig = 0;
            zählerPosRichtig = 0;
            //Werte eingeben
            for (int i = 0; i < 4; i++) {
                System.out.print("Buchstabe " + i + " eingeben: ");
                Scanner sc = new Scanner(System.in);  // Create a Scanner object
                //Eingabe in char konvertieren
                eingabe[i] = sc.next().charAt(0);

            }
            System.out.println(eingabe);
            checkChar();
        }
    }

    private static void checkChar() {

        for (int i = 0; i < eingabe.length; i++) {
            if (eingabe[i] == geheimcode[i]) {
                zählerAllesRichtig++;
            } else {
                boolean check = false;
                //while (check == false) {

                for (int j = 0; j < geheimcode.length; j++) {
                    if (geheimcode[j] == eingabe[i]) {
                        check = true;
                        zählerPosRichtig++;


                    }

                }


            }

        }

        System.out.println("Du hast " + zählerAllesRichtig + " richtige Buchstaben an der richtigen Position." +
                zählerPosRichtig + " Buchstaben kommen vor, sind jedoch an falscher Stelle.");


    }

}





