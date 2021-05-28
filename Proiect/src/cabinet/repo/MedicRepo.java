package cabinet.repo;

import cabinet.Client;
import cabinet.Medic;
import cabinet.configuration.DatabaseConfig;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class MedicRepo {
    public void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS medici" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30), " +
                "prenume varchar(30), specializare varchar(30), " +
                "numarPacienti int)";
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMedic(Medic medic) {
        String insertClientSQL = "INSERT INTO medici(nume, prenume, specializare, numarPacienti VALUES (?, ?, ?, ?)";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertClientSQL);
            preparedStatement.setString(1, medic.getNume());
            preparedStatement.setString(2, medic.getPrenume());
            preparedStatement.setString(3, medic.getSpecializare());
            preparedStatement.setInt(4, medic.getNumarPacienti());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Medic getMedicById(int id) {
        String selectSQL = "SELECT * FROM medici WHERE id = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToMedic(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public Medic mapToMedic (ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return new Medic(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), new String[]{});
        }
        return  null;
    }

    public ArrayList<Medic> getAllMedici() {
        ArrayList<Medic> medici = new ArrayList<Medic>();

        String selectSQL = "SELECT * FROM medici";
        Connection connection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Medic medic = new Medic(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), new String[]{});
                medici.add(medic);
            }
            return medici;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSpecializare (String specializare, int id) {
        String updateNameSQL = "UPDATE medici SET specializare = ? WHERE id = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement((updateNameSQL));
            preparedStatement.setString(1, specializare);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMedic(int id) {
        String deleteSQL = "DELETE FROM medici WHERE id = ?";
        Connection connection = DatabaseConfig.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement((deleteSQL));
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
