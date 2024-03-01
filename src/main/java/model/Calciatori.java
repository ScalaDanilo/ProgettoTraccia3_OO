package model;

import java.util.ArrayList;

public class Calciatori {
    public String Nome = new String();
    public String Cognome = new String();
    public String DataNascita = new String();
    public String DataRitiro = new String();
    public String Nazionalita = new String();
    public String PiedePreferito = new String();
    public String Id_Giocatore = new String();
    public double ValoreMercato;
    public ArrayList<Militanza> militanze;
    public ArrayList<Rosa> listaRose;
    public Utente utente;
    public Ruolo ruolo;
    public ArrayList<Trofei_Individuale> trofeiIndividuali;
    public ArrayList<Feature> features;
    public ArrayList<Trofei_Squadra> trofeiSquadra;

    public void setNome(String nome){
        this.Nome = nome;
    }

    public void setCognome(String cognome){
        this.Cognome = cognome;
    }

    public void setDataNascita(String dataNascita){
        this.DataNascita = dataNascita;
    }

    public void setDataRitiro(String dataRitiro){
        this.DataRitiro = dataRitiro;
    }

    public void setNazionalita(String nazionalita){
        this.Nazionalita = nazionalita;
    }

    public void setPiedePreferito(String piedePreferito){
        this.PiedePreferito = piedePreferito;
    }

    public void setId_Giocatore(String id_Giocatore){
        this.Id_Giocatore = id_Giocatore;
    }

    public void setValoreMercato(Double valoreMercato){
        this.ValoreMercato = valoreMercato;
    }

    public void setRuolo(Ruolo ruolo){
        this.ruolo = ruolo;
    }
}
