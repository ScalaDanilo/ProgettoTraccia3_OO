package model;

import java.util.ArrayList;

public class CompetizioniNazionali {
    public String nome;
    public String anno;
    public String Nazionalita;
    public Trofei_Squadra trofeoSquadra;
    public ArrayList<Squadre> listaSquadre;

    public CompetizioniNazionali(String nome, String anno, String nazionalita, Trofei_Squadra trofeoSquadra) {
        this.nome = nome;
        this.anno = anno;
        this.Nazionalita = nazionalita;
        this.trofeoSquadra = trofeoSquadra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getNazionalita() {
        return Nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        Nazionalita = nazionalita;
    }

    public Trofei_Squadra getTrofeoSquadra() {
        return trofeoSquadra;
    }

    public void setTrofeoSquadra(Trofei_Squadra trofeoSquadra) {
        this.trofeoSquadra = trofeoSquadra;
    }

    public ArrayList<Squadre> getListaSquadre() {
        return listaSquadre;
    }

    public void setListaSquadre(ArrayList<Squadre> listaSquadre) {
        this.listaSquadre = listaSquadre;
    }
}
