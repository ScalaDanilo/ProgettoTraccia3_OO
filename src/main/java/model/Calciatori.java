package model;

import java.util.ArrayList;

public class Calciatori {
    public String Id_Giocatore = new String();
    public String Nome = new String();
    public String Cognome = new String();
    public String DataNascita = new String();
    public String DataRitiro = new String();
    public String Nazionalita = new String();
    public String PiedePreferito = new String();
    public double ValoreMercato;
    public ArrayList<Militanza> militanze;
    public ArrayList<Rosa> listaRose;
    public Utente utente;
    public Ruolo ruolo;
    public ArrayList<Trofei_Individuale> trofeiIndividuali;
    public ArrayList<Feature> features;
    public ArrayList<Trofei_Squadra> trofeiSquadra;
}
