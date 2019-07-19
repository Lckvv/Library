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
public class AutorzyDAO {

    public static void dodajAutora(String imie, String nazwisko) throws Exception {
        String updateStmt = "INSERT INTO autorzy VALUES (null,'" + imie + "','" + nazwisko + "')";
        DBConnection.dbExecuteUpdate(updateStmt);
    }

    public static void usunAutora(int id) throws SQLException, Exception {
        String deleteStmt = "DELETE FROM autorzy WHERE id_autora='" + id + "'";
        DBConnection.dbExecuteUpdate(deleteStmt);
    }

    public static ObservableList<Autorzy> WyszukajAutorow() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM autorzy";
        ResultSet rsAutorzy = DBConnection.dbExecuteQuery(selectStmt);
        ObservableList<Autorzy> autorzyList = getAutorzyList(rsAutorzy);
        return autorzyList;
    }

    private static ObservableList<Autorzy> getAutorzyList(ResultSet rs) throws SQLException {
        ObservableList<Autorzy> autorzyList = FXCollections.observableArrayList();
        while (rs.next()) {
            Autorzy a = new Autorzy();
            a.setId_autora(rs.getInt("id_autora"));
            a.setImie(rs.getString("imie"));
            a.setNazwisko(rs.getString("nazwisko"));
            autorzyList.add(a);
        }
        return autorzyList;
    }

    public static ObservableList<Autorzy> wyborAutora() throws ClassNotFoundException, SQLException {
        String selectStmt = "SELECT * FROM autorzy";
        ResultSet rsAutorzy = DBConnection.dbExecuteQuery(selectStmt);
        ObservableList<Autorzy> grupList = getAutorzyListID(rsAutorzy);
        return grupList;
    }

    private static ObservableList<Autorzy> getAutorzyListID(ResultSet rs) throws SQLException {
        ObservableList<Autorzy> autorzyList = FXCollections.observableArrayList();

        while (rs.next()) {
            Autorzy a = new Autorzy();
            a.setId_autora(rs.getInt("id_autora"));
            a.setImie(rs.getString("imie"));
            a.setNazwisko(rs.getString("nazwisko"));
            autorzyList.add(a);
        }
        return autorzyList;
    }

}
