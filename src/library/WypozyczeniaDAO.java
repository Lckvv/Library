/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lucek
 */
public class WypozyczeniaDAO {

    public static void dodajWypozyczenia(int idKsiazki, int idCzytelnika, String data_wypozyczenia, String termin_zwrotu) throws Exception {
        String updateStmt = "INSERT INTO wypozyczenia VALUES (null,'" + idKsiazki + "','" + idCzytelnika + "','" + data_wypozyczenia + "','" + termin_zwrotu + "')";
        DBConnection.dbExecuteUpdate(updateStmt);
    }

    public static void usunWypozyczenia(int id) throws SQLException, Exception {
        String deleteStmt = "DELETE FROM wypozyczenia WHERE id_wypozyczenie='" + id + "'";
        DBConnection.dbExecuteUpdate(deleteStmt);

    }

    public static ObservableList<Wypozyczenia> WyszukajWypozyczenia() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM wypozyczenia";
        ResultSet rsWypozyczenia = DBConnection.dbExecuteQuery(selectStmt);
        ObservableList<Wypozyczenia> wypozyczeniaList = getWypozyczeniaList(rsWypozyczenia);
        return wypozyczeniaList;
    }

    private static ObservableList<Wypozyczenia> getWypozyczeniaList(ResultSet rs) throws SQLException {
        ObservableList<Wypozyczenia> wypozyczeniaList = FXCollections.observableArrayList();
        while (rs.next()) {
            Wypozyczenia a = new Wypozyczenia();
            a.setId_wypozyczenia(rs.getInt("id_wypozyczenia"));
            a.setId_czytelnika(rs.getInt("id_czytelnika"));
            a.setId_ksiazki(rs.getInt("id_ksiazki"));
            a.setData_wypozyczenia(rs.getString("data_wypozyczenia"));
            a.setTermin_zwrotu(rs.getString("termin_zwrotu"));
            wypozyczeniaList.add(a);
        }
        return wypozyczeniaList;

    }

}
