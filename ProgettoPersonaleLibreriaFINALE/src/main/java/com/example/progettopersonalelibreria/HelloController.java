package com.example.progettopersonalelibreria;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class HelloController
{
    @FXML
    private Button BottoneAggiuntaLibro;
    @FXML
    private Button BottoneRicerca;
    @FXML
    private Button BottoneAggiuntaTessera;
    @FXML
    private Button BottoneVendita;
    @FXML
    private Button BottoneStampaLibri;
    @FXML
    private Button BottoneStampaTessere;
    @FXML
    private TextField InputTitoloNome;
    @FXML
    private TextField InputGenereCognome;
    @FXML
    private TextField InputCodiceCodiceFis;
    @FXML
    private TextField InputPrezzo;
    @FXML
    private TextField PannelloPrincipale;
    private Libri libri;
    private Tessera tessere;
    private GestioneMetodi gm;

    public void initialize()
    {
        List<Libri>libri=new ArrayList<>();
        List<Tessera>tessere=new ArrayList<>();
        gm=new GestioneMetodi();
        BottoneAggiuntaLibro.setOnAction(actionEvent -> nuovoLibro(libri));
        BottoneRicerca.setOnAction(actionEvent -> ricercaLibro(libri));
        BottoneAggiuntaTessera.setOnAction(actionEvent -> nuovaTessera(tessere));
        BottoneVendita.setOnAction(actionEvent -> vendita(libri,tessere));
        BottoneStampaLibri.setOnAction(actionEvent -> stampaLibro(libri));
        BottoneStampaTessere.setOnAction(actionEvent -> stampaTessere(tessere));
    }
    private void nuovoLibro(List<Libri>libri)
    {
        String titolo = InputTitoloNome.getText();
        String genere = InputGenereCognome.getText();
        String codiceLibro = InputCodiceCodiceFis.getText();
        String prezzo = InputPrezzo.getText();
        if(titolo.isEmpty()||genere.isEmpty()||codiceLibro.isEmpty()||prezzo.isEmpty())
        {
            PannelloPrincipale.setText("Inserire tutti i parametri");
        }
        try
        {
            int codice=Integer.parseInt(codiceLibro);
            double costo=Double.parseDouble(prezzo);
            libri.add(new Libri(titolo, codice, costo, genere));
            PannelloPrincipale.setText("Libro aggiunto");
        } catch (NumberFormatException e)
        {
            throw new RuntimeException(e);
        }

    }
    private void ricercaLibro(List<Libri>libri)
    {
        String titolo = InputTitoloNome.getText();
        if(titolo.isEmpty())
        {
            PannelloPrincipale.setText("Inserisci il titolo del libro");
        }
        if(libri!=null)
        {
            for(int i=0;i< libri.size();i++)
            {
                if(libri.get(i).getTitolo().equals(titolo))
                {
                    PannelloPrincipale.setText("Titolo libro: " + libri.get(i).getTitolo() + " Genere: " + libri.get(i).getGenere() + " Codice: " + libri.get(i).getCodice() + " Prezzo: " + libri.get(i).getCosto());
                }
            }
        }
        else
        {
            PannelloPrincipale.setText("Libro non presente");
        }
    }
    private void nuovaTessera(List<Tessera>tessere)
    {
        String nome = InputTitoloNome.getText();
        String cognome = InputGenereCognome.getText();
        String codiceFis = InputCodiceCodiceFis.getText();
        if(nome.isEmpty()||cognome.isEmpty()||codiceFis.isEmpty())
        {
            PannelloPrincipale.setText("Inserire tutti i parametri");
        }
        try
        {
            tessere.add(new Tessera(nome,cognome,codiceFis));
            PannelloPrincipale.setText("Tessera aggiunta");
        } catch (NumberFormatException e)
        {
            throw new RuntimeException(e);
        }
    }
    private void vendita(List<Libri>libri, List<Tessera>tessere)
    {
        String codiceFis=InputCodiceCodiceFis.getText();
        String costo=InputPrezzo.getText();
        String titolo=InputTitoloNome.getText();
        if(codiceFis.isEmpty()||titolo.isEmpty()||costo.isEmpty())
        {
            PannelloPrincipale.setText("Inserire titolo, prezzo e codice fiscle (se in possesso di una tessera)");
        }
        try
        {
            double Prezzo = Double.parseDouble(costo);
            if(libri!=null)
            {
                for(int i=0;i<libri.size();i++)
                {
                    if(libri.get(i).getTitolo().equals(titolo) && tessere.get(i).getCodiceFiscale().equals(codiceFis))
                    {
                        Prezzo-=Prezzo*10/100;
                        PannelloPrincipale.setText("Titolo: " + libri.get(i).getTitolo() + " Genere: " + libri.get(i).getGenere() + " Codice: " + libri.get(i).getCodice() + " Prezzo: " + Prezzo);
                    }
                    else if(libri.get(i).getTitolo().equals(titolo) && !tessere.get(i).getCodiceFiscale().equals(codiceFis))
                    {
                        PannelloPrincipale.setText("Titolo: " + libri.get(i).getTitolo() + " Genere: " + libri.get(i).getGenere() + " Codice: " + libri.get(i).getCodice() + " Prezzo: " + Prezzo);
                    }
                    else
                    {
                        PannelloPrincipale.setText("Libro non trovato");
                    }
                }
            }
        } catch (RuntimeException e)
        {
            throw new RuntimeException(e);
        }
    }
    private void stampaLibro(List<Libri>libri)
    {
        for(int i=0;i<libri.size();i++)
        {
            PannelloPrincipale.setText("Titolo libro: " + libri.get(i).getTitolo() + " Genere: " + libri.get(i).getGenere() + " Codice: " + libri.get(i).getCodice() + " Prezzo: " + libri.get(i).getCosto());
        }
    }
    private void stampaTessere(List<Tessera>tessere)
    {
        for (int i=0;i< tessere.size();i++)
        {
            PannelloPrincipale.setText("Nome persona: " + tessere.get(i).getNome() + " Cognome: " + tessere.get(i).getCognome() + " Codice fiscale: " + tessere.get(i).getCodiceFiscale());
        }
    }
}