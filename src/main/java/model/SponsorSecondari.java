package model;

public class SponsorSecondari {
    public String nome;
    public int finanziamento;
    public Squadre squadra;

    public SponsorSecondari(Squadre squadra, String nomeSponsor) {
        this.squadra = squadra;
        this.nome = nomeSponsor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFinanziamento() {
        return finanziamento;
    }

    public void setFinanziamento(int finanziamento) {
        this.finanziamento = finanziamento;
    }

    public Squadre getSquadra() {
        return squadra;
    }

    public void setSquadra(Squadre squadra) {
        this.squadra = squadra;
    }
}
