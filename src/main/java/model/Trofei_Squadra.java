package model;

import java.util.ArrayList;

public class Trofei_Squadra {

    public String nomeTrofeo;
    public int annoAssegnazione;
    public Squadre squadra;
    public ArrayList<Calciatori> calciatori;
    public CompetizioniNazionali competizioniNazionali;
    public CompetizioniNonNazionali competizioniNonNazionali;

    void Trofei_Squadra (CompetizioniNazionali compNaz, String nome, int anno) {
        this.competizioniNazionali = compNaz;
        this.nomeTrofeo = nome;
        this.annoAssegnazione = anno;
    }

    void Trofei_Squadra (CompetizioniNonNazionali compNonNaz, String nome, int anno) {
        this.competizioniNonNazionali = compNonNaz;
        this.nomeTrofeo = nome;
        this.annoAssegnazione = anno;
    }

    public String getNomeTrofeo() {
        return nomeTrofeo;
    }

    public void setNomeTrofeo(String nomeTrofeo) {
        this.nomeTrofeo = nomeTrofeo;
    }

    public int getAnnoAssegnazione() {
        return annoAssegnazione;
    }

    public void setAnnoAssegnazione(int annoAssegnazione) {
        this.annoAssegnazione = annoAssegnazione;
    }

    public ArrayList<Calciatori> getCalciatori() {
        return calciatori;
    }

    public void setCalciatori(ArrayList<Calciatori> calciatori) {
        this.calciatori = calciatori;
    }

    public CompetizioniNazionali getCompetizioniNazionali() {
        return competizioniNazionali;
    }

    public void setCompetizioniNazionali(CompetizioniNazionali competizioniNazionali) {
        this.competizioniNazionali = competizioniNazionali;
    }

    public CompetizioniNonNazionali getCompetizioniNonNazionali() {
        return competizioniNonNazionali;
    }

    public void setCompetizioniNonNazionali(CompetizioniNonNazionali competizioniNonNazionali) {
        this.competizioniNonNazionali = competizioniNonNazionali;
    }
}
