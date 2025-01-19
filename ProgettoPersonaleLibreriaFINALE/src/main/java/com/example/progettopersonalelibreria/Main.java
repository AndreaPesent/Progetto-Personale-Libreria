package com.example.progettopersonalelibreria;

import java.util.Scanner;

public class Main extends GestioneMetodi
{
    public static void main(String[] args)
    {
       GestioneMetodi gm=new GestioneMetodi();
        Scanner in = new Scanner(System.in);
        int scelta = 0;
        int indice1 = 0;
        int indice2 = 0;
        String titolo = "";
        int codice = 0;
        double costo =0.0;
        String genere = "";
        String nome = "";
        String cognome = "";
        String CodiceFiscale = "";
        Libri[] raccolta = new Libri[10];
        Tessera[] tessere = new Tessera[10];

        do {
            System.out.println("SCEGLI UNA DELLE SEGUENTI OPZIONI");
            System.out.println("1- Inserisci un libro");
            System.out.println("2- Ricerca di un libro");
            System.out.println("3- Inserisci nuova tessera");
            System.out.println("4- Vendita libro libro");
            System.out.println("5- Stampa tutti i libri presenti");
            System.out.println("6- Stampa tutte le tessere presenti");
            scelta = in.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il titolo del libro");
                    titolo = in.next();
                    System.out.println("Inserisci il codice del libro");
                    codice = in.nextInt();
                    System.out.println("Inserisci il prezzo del libro");
                    costo = in.nextDouble();
                    System.out.println("Inserisci il genere del libro");
                    genere = in.next();
                    Libri libro = new Libri(titolo, codice, costo, genere);
                    gm.AggiuntaLibro(raccolta, libro, indice1);
                    indice1++;
                    break;
                case 2:
                    System.out.println("Inserisci il titolo del libro ");
                    titolo = in.next();
                    gm.RicercaLibro(raccolta, titolo, indice1);
                    System.out.println(gm.RicercaLibro(raccolta, titolo, indice1));
                    break;
                case 3:
                    System.out.println("Inserisci il nome della persona");
                    nome = in.next();
                    System.out.println("Inserisci il cognome della persona");
                    cognome = in.next();
                    System.out.println("Inserisci il codice fiscale della persona");
                    CodiceFiscale = in.next();
                    Tessera carta = new Tessera(nome, cognome, CodiceFiscale, titolo, codice, costo, genere);
                    gm.AggiuntaTessera(tessere, carta, indice2);
                    indice2++;
                    break;
                case 4:
                    System.out.println("Inserisci il titolo del libro che vuoi comprare");
                    titolo = in.next();
                    System.out.println("Inserisci il codice fiscale");
                    CodiceFiscale = in.next();
                    if (gm.EsistenzaLibro(raccolta, indice1, titolo)) {
                        gm.VenditaLibro(raccolta, tessere, indice1, titolo, CodiceFiscale, costo);
                        System.out.println(gm.VenditaLibro(raccolta, tessere, indice1, titolo, CodiceFiscale, costo));
                    } else
                    {
                        System.out.println("Libro non disponibile");
                    }
                    break;
                case 5:
                    gm.Stampa(raccolta, indice1);
                    System.out.println(gm.Stampa(raccolta, indice1));
                    break;
                case 6:
                    gm.StampaTessera(tessere, indice2);
                    System.out.println(gm.StampaTessera(tessere, indice2));
            }
        } while(scelta != 0);
    }
}