package model;

import java.util.ArrayList;

public class Squadre {
    public String NomeSquadra = new String();
    public String Nazionalita = new String();
    public Militanza militanza;
    public SponsorSecondari sponsorSecondari;
    public SponsorTec sponsorTec;
    public ArrayList<CompetizioniNazionali> competizioniNazionali;
    public ArrayList<CompetizioniNonNazionali> competizioniNonNazionali;
    public Trofei_Squadra trofeiSquadra;
    public Rosa rosa;

    public Squadre(String nome, String nazione, SponsorTec sponsorTec) {
        this.NomeSquadra = nome;
        this.Nazionalita = nazione;
        this.sponsorTec = sponsorTec;
    }
    public Squadre(String nome, String nazione) {
        this.NomeSquadra = nome;
        this.Nazionalita = nazione;
    }

    public Squadre(String nomeSquadra) {
        NomeSquadra = nomeSquadra;
    }

    public String getNomeSquadra() {
        return NomeSquadra;
    }

    public void setNomeSquadra(String nomeSquadra) {
        NomeSquadra = nomeSquadra;
    }

    public String getNazionalita() {
        return Nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        Nazionalita = nazionalita;
    }

    public Militanza getMilitanza() {
        return militanza;
    }

    public void setMilitanza(Militanza militanza) {
        this.militanza = militanza;
    }

    public SponsorSecondari getSponsorSecondari() {
        return sponsorSecondari;
    }

    public void setSponsorSecondari(SponsorSecondari sponsorSecondari) {
        this.sponsorSecondari = sponsorSecondari;
    }

    public SponsorTec getSponsorTec() {
        return sponsorTec;
    }

    public void setSponsorTec(SponsorTec sponsorTec) {
        this.sponsorTec = sponsorTec;
    }

    public ArrayList<CompetizioniNazionali> getCompetizioniNazionali() {
        return competizioniNazionali;
    }

    public void setCompetizioniNazionali(ArrayList<CompetizioniNazionali> competizioniNazionali) {
        this.competizioniNazionali = competizioniNazionali;
    }

    public ArrayList<CompetizioniNonNazionali> getCompetizioniNonNazionali() {
        return competizioniNonNazionali;
    }

    public void setCompetizioniNonNazionali(ArrayList<CompetizioniNonNazionali> competizioniNonNazionali) {
        this.competizioniNonNazionali = competizioniNonNazionali;
    }

    public Trofei_Squadra getTrofeiSquadra() {
        return trofeiSquadra;
    }

    public void setTrofeiSquadra(Trofei_Squadra trofeiSquadra) {
        this.trofeiSquadra = trofeiSquadra;
    }

    public Rosa getRosa() {
        return rosa;
    }

    public void setRosa(Rosa rosa) {
        this.rosa = rosa;
    }
}
