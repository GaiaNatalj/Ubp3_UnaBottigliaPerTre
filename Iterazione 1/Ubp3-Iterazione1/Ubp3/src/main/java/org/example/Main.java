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


                default:
                    break;
            }
        }while (i!=0);
    }catch (Exception e){
        System.out.print("Errore inserimento!");
    }

    }


}