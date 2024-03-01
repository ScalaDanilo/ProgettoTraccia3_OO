package DAO;

import model.SponsorSecondari;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Optional;

public interface HomeAdminDAO {
    public String prendiSquadreDalDB() throws SQLException;
    public void inserisciCalcRuoloSponSquaMil(String nome, String cognome, String nazion, Date dataNascita,
                                              Optional<Date> dataRitiro, String piedePR, String ruoli, String nomeSponsor, String nomeSquadra,
                                              String nazSquadra, Date dataInizio, Optional<Date> dataFine, int tiriSegnati, int partiteGiocate,
                                              String goalSubiti) throws SQLException;
    public void inserisciSquadra(String nomeSquadra, String nomeSponsor, String nazione) throws SQLException;
    public void inserisciSponsorSecondario(SponsorSecondari sponsorSecondari) throws SQLException;
    public void inserisciCompetizione(String nomeComp, Integer annoInizio, String nazione, String tipo, String nomeTrofeo, Integer annoFine) throws SQLException;
    public int vediQuantiCalciatori(String nome, String cognome);
    public String prendiGiocatoriUgualiDalDB(String nome, String cognome) throws SQLException;
    public boolean prendiRuoloCalciatoreFacile(String nome, String cognome);
    public boolean prendiRuoloCalciatoreDifficile(String nome, String cognome, String nazionalita, Date data);
    public String getIDGiocatore(String nome, String cognome, String nazione, Date nascita);
    public void inserisciMilitanza (String idGiocatore, Optional<Date> dataFineExMilitanzaDate, Date dataInizioNuovaMilitanzaDate, Optional<Date> dataFineNuovaMilitanzaDate,
                                    String squadra, int tiriSegnatiInt, int partiteGiocateInt, String goalSubitiInt) throws SQLException;
    public String prendiGiocatori() throws SQLException;
    public Date checkLastMil(String idGiocatore);
    public String prendiFeature(String id);
    public boolean checkDataRitiro(String id);
    public void inserisciDataRitiro(String idGio, Date dataRitiro);
    public void inserisciFeature(String idGiocatore, String feature);
    public String prendiCompetizioni();
    public String prendiAnni(String comp) throws SQLException;
    public String checkCompetizione(String competizione);
    public String prendiSquadreIdonee(String comp, int anno) throws SQLException;
    public String prendiTrofeiIndividuali() throws SQLException;
    public String prendiAnniTrofeo(String trofeo) throws SQLException;
    public String prendiGiocatoriValidi(int anno) throws SQLException;
    public String prendiTrofeiSquadra() throws SQLException;
    public String prendiSquadreIdoneePerTrofeo(int anno, String nomeTrof) throws SQLException;
    public void inserisciTrofeoIndividuale(String nomeTrofeo, int anno, String idGiocatore) throws SQLException;
    public void inserisciTrofeoDiSquadra(String nomeTrofeo, int anno, String squadra) throws SQLException;
    public void inserisciSquadraInCompetizione(String nomeSq, String nomeCp, int anno) throws  SQLException;
}

