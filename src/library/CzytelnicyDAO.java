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
public class CzytelnicyDAO {

    public static void dodajCzytelnika(String imie, String nazwisko, String adres, String nr_telefonu, String data_urodzenia) throws Exception {
        String updateStmt = "INSERT INTO czytelnicy VALUES (null,'" + imie + "','" + nazwisko + "','" + adres + "','" + nr_telefonu + "','" + data_urodzenia + "')";
        DBConnection.dbExecuteUpdate(updateStmt);
    }

    public static void usunCzytelnika(int id) throws SQLException, Exception {
        String deleteStmt = "DELETE FROM czytelnicy WHERE id_czytelnika='" + id + "'";
        DBConnection.dbExecuteUpdate(deleteStmt);

    }

    public static ObservableList<Czytelnicy> WyszukajCzytelnikow() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM czytelnicy";
        ResultSet rsCzytelnicy = DBConnection.dbExecuteQuery(selectStmt);
        ObservableList<Czytelnicy> czytelnicyList = getCzytelnicyList(rsCzytelnicy);
        return czytelnicyList;
    }

    private static ObservableList<Czytelnicy> getCzytelnicyList(ResultSet rs) throws SQLException {
        ObservableList<Czytelnicy> czytelnicyList = FXCollections.observableArrayList();
        while (rs.next()) {
            Czytelnicy a = new Czytelnicy();
            a.setId_czytelnika(rs.getInt("id_czytelnika"));
            a.setImie(rs.getString("imie"));
            a.setNazwisko(rs.getString("nazwisko"));
            a.setAdres(rs.getString("adres"));
            a.setNr_telefonu(rs.getString("nr_telefonu"));
            a.setData_urodzenia(rs.getString("data_urodzenia"));
            czytelnicyList.add(a);
        }
        return czytelnicyList;

    }

    public static ObservableList<Czytelnicy> wyborCzytelnika() throws ClassNotFoundException, SQLException {
        String selectStmt = "SELECT * FROM czytelnicy";
        ResultSet rsCzytelnicy = DBConnection.dbExecuteQuery(selectStmt);
        ObservableList<Czytelnicy> grupList = getCzytelnicyListID(rsCzytelnicy);
        return grupList;
    }

    private static ObservableList<Czytelnicy> getCzytelnicyListID(ResultSet rs) throws SQLException {
        ObservableList<Czytelnicy> czytelnicyList = FXCollections.observableArrayList();

        while (rs.next()) {
            Czytelnicy a = new Czytelnicy();
            a.setId_czytelnika(rs.getInt("id_czytelnika"));
            a.setImie(rs.getString("imie"));
            a.setNazwisko(rs.getString("nazwisko"));
            a.setAdres(rs.getString("adres"));
            a.setNr_telefonu(rs.getString("nr_telefonu"));
            a.setData_urodzenia(rs.getString("data_urodzenia"));
            czytelnicyList.add(a);

        }
        return czytelnicyList;
    }

}
