package com.example.progettopersonalelibreria;

public class Tessera extends Libri
{
    private String nome;
    private String cognome;
    private String CodiceFiscale;

    public Tessera(String nome, String cognome, String CodiceFiscale, String titolo, int codice, double costo, String genere)
    {
        super(titolo, codice, costo, genere);
        this.nome = nome;
        this.cognome = cognome;
        this.CodiceFiscale = CodiceFiscale;
    }

    public Tessera() {

    }

    public Tessera(String nome, String cognome, String codiceFis) {
        this.nome=nome;
        this.cognome=cognome;
        this.CodiceFiscale=codiceFis;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getCognome()
    {
        return this.cognome;
    }

    public String getCodiceFiscale()
    {
        return this.CodiceFiscale;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String CodiceFiscale)
    {
        this.CodiceFiscale = CodiceFiscale;
    }

    public String toString()
    {
        return "Nome: " + this.nome + " Cognome: " + this.cognome + " Codice fiscale: " + this.CodiceFiscale;
    }
}
