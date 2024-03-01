package DAO;

import java.util.ArrayList;

public interface HomeUtenteDAO {
    String[] Calciatori(String nome);

    String[] CalcRuolo(String ruolo);

    String[] CalcPiede(String piede);

    String[] CalcGoalSegnati(int goal);

    String[] CalcGoalSubiti(int goal);

    String[] CalcEta(int eta);

    String[] CalcSquadra(String squadra);

    String[] Top();
}
