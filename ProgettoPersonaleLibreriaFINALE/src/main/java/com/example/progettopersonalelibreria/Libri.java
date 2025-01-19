package com.example.progettopersonalelibreria;

public class Libri
{
    private String titolo;
    int codice;
    double costo;
    private String genere;

    public Libri(String titolo, int codice, double costo, String genere)
    {
        this.costo = costo;
        this.codice = codice;
        this.titolo = titolo;
        this.genere = genere;
    }

    public Libri() {

    }

    public String getTitolo()
    {
        return this.titolo;
    }

    public String getGenere()
    {
        return this.genere;
    }

    public int getCodice()
    {
        return this.codice;
    }

    public double getCosto()
    {
        return this.costo;
    }

    public void setTitolo(String titolo)
    {
        this.titolo = titolo;
    }

    public void setGenere(String genere)
    {
        this.genere = genere;
    }

    public void setCodice(int codice)
    {
        this.codice = codice;
    }

    public void setCosto(double costo)
    {
        this.costo = costo;
    }

    public void Visualizza()
    {
        System.out.println("Titolo" + this.titolo + " Genere: " + this.genere + " Codice: " + this.codice + " Costo: " + this.costo);
    }
}
