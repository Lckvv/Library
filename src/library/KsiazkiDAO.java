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
public class KsiazkiDAO {

    public static void dodajKsiazke(int id_autora, String wydawnictwo, String tytul, String rok, String nr_ksiazki, String ilosc_ksiazek) throws Exception {
        String updateStmt = "INSERT INTO ksiazki VALUES (null,'" + id_autora + "','" + wydawnictwo + "','" + tytul + "','" + rok + "','" + nr_ksiazki + "','" + ilosc_ksiazek + "' )";
        DBConnection.dbExecuteUpdate(updateStmt);
    }

    public static void usunKsiazke(int id) throws SQLException, Exception {
        String deleteStmt = "DELETE FROM ksiazki WHERE id_ksiazki='" + id + "'";
        DBConnection.dbExecuteUpdate(deleteStmt);

    }

    public static ObservableList<Ksiazki> WyszukajKsiazki() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM ksiazki";
        ResultSet rsKsiazki = DBConnection.dbExecuteQuery(selectStmt);
        ObservableList<Ksiazki> ksiazkiList = getKsiazkiList(rsKsiazki);
        return ksiazkiList;
    }

    private static ObservableList<Ksiazki> getKsiazkiList(ResultSet rs) throws SQLException {
        ObservableList<Ksiazki> ksiazkiList = FXCollections.observableArrayList();
        while (rs.next()) {
            Ksiazki a = new Ksiazki();
            a.setId_ksiazki(rs.getInt("id_ksiazki"));
            a.setId_autora(rs.getInt("id_autora"));
            a.setWydawnictwo(rs.getString("wydawnictwo"));
            a.setTytul(rs.getString("tytul"));
            a.setRok_wydania(rs.getString("rok_wydania"));
            a.setNr_ISBN(rs.getString("nr_ISBN"));
            a.setIlosc_ksiazek(rs.getString("ilosc_ksiazek"));
            ksiazkiList.add(a);
        }
        return ksiazkiList;
    }
         public static ObservableList<Ksiazki> wyborKsiazki() throws ClassNotFoundException, SQLException {
        String selectStmt = "SELECT * FROM ksiazki";
        ResultSet rsKsiazki = DBConnection.dbExecuteQuery(selectStmt);
        ObservableList<Ksiazki> grupList = getKsiazkiListID(rsKsiazki);
        return grupList;
    }

    private static ObservableList<Ksiazki> getKsiazkiListID(ResultSet rs) throws SQLException {
        ObservableList<Ksiazki> ksiazkiList = FXCollections.observableArrayList();

        while (rs.next()) {
            Ksiazki a = new Ksiazki();
            a.setId_ksiazki(rs.getInt("id_ksiazki"));
            a.setId_autora(rs.getInt("id_autora"));
            a.setWydawnictwo(rs.getString("wydawnictwo"));
            a.setTytul(rs.getString("tytul"));
            a.setRok_wydania(rs.getString("rok_wydania"));
            a.setNr_ISBN(rs.getString("nr_ISBN"));
            a.setIlosc_ksiazek(rs.getString("ilosc_ksiazek"));
            ksiazkiList.add(a);
        }
        return ksiazkiList;
    }

    }
    


