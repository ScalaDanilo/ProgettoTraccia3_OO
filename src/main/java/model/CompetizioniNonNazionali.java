package model;

import java.util.ArrayList;

public class CompetizioniNonNazionali {
    public String nome;
    public String anno;
    public String tipo;
    public Trofei_Squadra trofeoSquadra;
    public ArrayList<Squadre> listaSquadre;
    public CompetizioniNonNazionali(String nome, String anno, String tipo, Trofei_Squadra trofeoSquadra) {
        this.nome = nome;
        this.anno = anno;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
