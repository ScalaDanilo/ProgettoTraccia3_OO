package PostgresDAO;

import Connessione.ConnessioneDB;
import DAO.HomeUtenteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtentePostgreDAO implements HomeUtenteDAO {
    Connection conn = new ConnessioneDB().connect_to_db("postgres","postgres","password");
    @Override
    public String[] Calciatori(String nome)
    {
        String query = "SELECT * FROM visualizzaCalc(?)";

        String[] TotCalciatore = new String[0];

        try (PreparedStatement preparedStatement = conn.prepareStatement(query))
        {
            preparedStatement.setString(1, nome);

            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    TotCalciatore = (resultSet.getString(1) != null) ? resultSet.getString(1).split(",") : new String[0];
                    //System.out.println(TotCalciatore[0]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return TotCalciatore;
    }

    @Override
    public String[] CalcRuolo(String ruolo) {
        String query = "SELECT * FROM ricercaperruolo(?)";

        String[] TotCalciatore = new String[0];

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setString(1, ruolo);

            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    TotCalciatore = (resultSet.getString(1) != null) ? resultSet.getString(1).split(",") : new String[0];
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return TotCalciatore;
    }

    @Override
    public String[] CalcPiede(String piede) {
        String query = "SELECT * FROM visualizzaperpiedepr(?)";

        String[] TotCalciatore = new String[0];

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setString(1, piede);

            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    TotCalciatore = (resultSet.getString(1) != null) ? resultSet.getString(1).split(",") : new String[0];
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return TotCalciatore;
    }

    @Override
    public String[] CalcGoalSegnati(int goal) {
        String query = "SELECT * FROM ricercapergoalsegnati(?)";

        String[] TotCalciatore = new String[0];

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setInt(1, goal);

            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    TotCalciatore = (resultSet.getString(1) != null) ? resultSet.getString(1).split(",") : new String[0];
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return TotCalciatore;
    }

    @Override
    public String[] CalcGoalSubiti(int goal) {
        String query = "SELECT * FROM ricercapergoalsubiti(?)";

        String[] TotCalciatore = new String[0];

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setInt(1, goal);

            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    TotCalciatore = (resultSet.getString(1) != null) ? resultSet.getString(1).split(",") : new String[0];
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return TotCalciatore;
    }

    @Override
    public String[] CalcEta(int eta) {
        String query = "SELECT * FROM ricercapereta(?)";

        String[] TotCalciatore = new String[0];

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setInt(1, eta);

            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    TotCalciatore = (resultSet.getString(1) != null) ? resultSet.getString(1).split(",") : new String[0];
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return TotCalciatore;
    }

    @Override
    public String[] CalcSquadra(String squadra) {
        String query = "SELECT * FROM ricercapersquadra(?)";

        String[] TotCalciatore = new String[0];

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setString(1, squadra);

            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                if (resultSet.next())
                {
                    TotCalciatore = (resultSet.getString(1) != null) ? resultSet.getString(1).split(",") : new String[0];
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return TotCalciatore;
    }

    @Override
    public String[] Top() {
        String query = "SELECT C.nome FROM CALCIATORE AS C JOIN MILITANZA AS M ON C.Id_Giocatore = M.giocatore GROUP BY C.nome ORDER BY MAX(M.tirisegnati) LIMIT 10;";

        String[] TotCalciatore = new String[10];

        int i = 0;

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            try (ResultSet resultSet = preparedStatement.executeQuery())
            {
                while (resultSet.next())
                {
                    TotCalciatore[i] = resultSet.getString(1);
                    i++;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return TotCalciatore;
    }
}
