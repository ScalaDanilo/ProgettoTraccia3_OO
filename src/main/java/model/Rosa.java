package model;

import java.util.ArrayList;

public class Rosa {
    public String anno;
    public ArrayList<Squadre> listaSquadre;
    public ArrayList<Calciatori> calciatore;

    public Rosa(String anno, ArrayList<Squadre> listaSquadre, ArrayList<Calciatori> calciatore) {
        this.anno = anno;
        this.listaSquadre = listaSquadre;
        this.calciatore = calciatore;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public ArrayList<Squadre> getListaSquadre() {
        return listaSquadre;
    }

    public void setListaSquadre(ArrayList<Squadre> listaSquadre) {
        this.listaSquadre = listaSquadre;
    }

    public ArrayList<Calciatori> getCalciatore() {
        return calciatore;
    }

    public void setCalciatore(ArrayList<Calciatori> calciatore) {
        this.calciatore = calciatore;
    }
}
