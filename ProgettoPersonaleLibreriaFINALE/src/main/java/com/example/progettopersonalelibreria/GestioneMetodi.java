package com.example.progettopersonalelibreria;

import java.util.Objects;

public class GestioneMetodi
{

    public void AggiuntaLibro(Libri[] raccolta, Libri libro, int indice1)
    {
        raccolta[indice1] = libro;
    }

    public String Stampa(Libri[] raccolta, int indice1)
    {
        String a = "";
        for(int i = 0; i < indice1; ++i)
        {
            a = "Titolo: " + raccolta[i].getTitolo() + " genere: " + raccolta[i].getGenere() + " codice: " + raccolta[i].getCodice() + " prezzo: " + raccolta[i].getCosto();
        }
        return a;
    }

    public String StampaTessera(Tessera[] tessere, int indice2)
    {
        String b = "";
        for(int i = 0; i < indice2; ++i)
        {
            b = "nome: " + tessere[i].getNome() + " cognome: " + tessere[i].getCognome() + " codiceFis: " + tessere[i].getCodiceFiscale();
        }
        return b;
    }

    public void AggiuntaTessera(Tessera[] tessere, Tessera carta, int indice2)
    {
        tessere[indice2] = carta;
    }

    public String RicercaLibro(Libri[] raccolta, String titolo, int indice1)
    {
        String s = "";
        for(int i = 0; i < indice1; ++i)
        {
            if (Objects.equals(titolo, raccolta[i].getTitolo()))
            {
                s = "Titolo: " + raccolta[i].getTitolo() + " genere: " + raccolta[i].getGenere() + " codice: " + raccolta[i].getCodice() + " costo: " + raccolta[i].getCosto();
            }
        }
        return s;
    }

    public boolean EsistenzaLibro(Libri[] raccolta, int indice1, String titolo)
    {
        for(int i = 0; i < indice1; ++i)
        {
            if (Objects.equals(titolo, raccolta[i].getTitolo()))
            {
                return true;
            }
        }
        return false;
    }

    public double VenditaLibro(Libri[] raccolta, Tessera[] tessere, int indice1, String titolo, String CodiceFiscale, double costo)
    {
        for(int i = 0; i < indice1; ++i)
        {
            if (Objects.equals(titolo, raccolta[i].getTitolo()) && Objects.equals(CodiceFiscale, tessere[i].getCodiceFiscale()))
            {
                costo -= costo * 10.0 / 100.0;
            }
        }
        return costo;
    }
}
