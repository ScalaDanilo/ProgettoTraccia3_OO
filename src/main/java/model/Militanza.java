package model;

import java.util.ArrayList;

public class Militanza {
        public String Id_Militanza = new String();
        public String DataInizio = new String();
        public String DataFine = new String();
        public int TiriSegnati;
        public int PartiteGiocate;
        public ArrayList<Calciatori> calciatori;
        public ArrayList<Squadre> squadre;

        public Militanza(String id_Militanza, String dataInizio, String dataFine, int tiriSegnati, int partiteGiocate, ArrayList<Calciatori> calciatori, ArrayList<Squadre> squadre) {
                Id_Militanza = id_Militanza;
                DataInizio = dataInizio;
                DataFine = dataFine;
                TiriSegnati = tiriSegnati;
                PartiteGiocate = partiteGiocate;
                this.calciatori = calciatori;
                this.squadre = squadre;
        }

        public String getId_Militanza() {
                return Id_Militanza;
        }

        public void setId_Militanza(String id_Militanza) {
                Id_Militanza = id_Militanza;
        }

        public String getDataInizio() {
                return DataInizio;
        }

        public void setDataInizio(String dataInizio) {
                DataInizio = dataInizio;
        }

        public String getDataFine() {
                return DataFine;
        }

        public void setDataFine(String dataFine) {
                DataFine = dataFine;
        }

        public int getTiriSegnati() {
                return TiriSegnati;
        }

        public void setTiriSegnati(int tiriSegnati) {
                TiriSegnati = tiriSegnati;
        }

        public int getPartiteGiocate() {
                return PartiteGiocate;
        }

        public void setPartiteGiocate(int partiteGiocate) {
                PartiteGiocate = partiteGiocate;
        }

        public ArrayList<Calciatori> getCalciatori() {
                return calciatori;
        }

        public void setCalciatori(ArrayList<Calciatori> calciatori) {
                this.calciatori = calciatori;
        }

        public ArrayList<Squadre> getSquadre() {
                return squadre;
        }

        public void setSquadre(ArrayList<Squadre> squadre) {
                this.squadre = squadre;
        }
}
