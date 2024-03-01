package model;

public class SponsorTec {
    public String nome;
    public int finanziamento;
    public Squadre squadra;

    public SponsorTec(Squadre squadra, String nome) {
        this.nome = nome;
        this.squadra = squadra;
    }
    public SponsorTec(String nome) {
        this.nome = nome;
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
