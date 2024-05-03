package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import org.example.Ubp3;

public class Main {
    public static void main(String[] args)  {
try {
        Scanner scan = new Scanner(System.in);
        int i;

         do{
            System.out.println("\nSeleziona:");
            System.out.println("1- Inserisci vino" +
                    "\n2-Crea ordine fornitore" +
                    "\n3-Inserisci cliente" +
                    "\n4-Acquisto vini" +
                    "\n5-Ricerca vendita" +
                    "\n6-Inserisci prenotazione vini per cliente " +
                    "\n7-Aggiungi punti" +
                    "\n8-Inserisci nuovo codice sconto" +
                    "\n9-Sottrai punti" +
                    "\n0-Esci");
            i = Integer.parseInt(scan.nextLine());
            switch (i) {
                case 1:
                    org.example.CasiDuso.UC1();
                        break;

                case 2:
                    org.example.CasiDuso.UC2();
                    break;

                case 3:
                    org.example.CasiDuso.UC3();
                    break;

                case 4:
                    org.example.CasiDuso.UC4();
                break;

                case 5:
                    org.example.CasiDuso.UC5();
                    break;
                case 6:
                    org.example.CasiDuso.UC6();
                    break;
                case 7:
                    org.example.CasiDuso.UC7();
                    break;
                case 8:
                    org.example.CasiDuso.UC8();
                    break;
                case 9:
                    org.example.CasiDuso.UC9();
                    break;

                default:
                    break;
            }
        }while (i!=0);
    }catch (Exception e){
        System.out.print("Errore inserimento!");
    }
    }


}