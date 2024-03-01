package model;

public class Ruolo {
    public Calciatori calciatore;
    public String ruoli;

    public Ruolo(Calciatori calciatore, String ruoli) {
        this.calciatore = calciatore;
        this.ruoli = ruoli;
    }


    public Calciatori getCalciatore() {
        return calciatore;
    }

    public void setCalciatore(Calciatori calciatore) {
        this.calciatore = calciatore;
    }

    public String getRuoli() {
        return ruoli;
    }

    public void setRuoli(String ruoli) {
        this.ruoli = ruoli;
    }
}
