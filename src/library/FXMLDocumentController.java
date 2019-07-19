/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author Lucek
 */
public class FXMLDocumentController implements Initializable {

    //FXML Autorów
    @FXML
    private TextField idAutora;

    @FXML
    private TextField nazwiskoAutora;

    @FXML
    private TextField imieAutora;

    //FXML Czytelników
    @FXML
    private TextField idCzytelnika;

    @FXML
    private TextField imieCzytelnika;

    @FXML
    private TextField nazwiskoCzytelnika;

    @FXML
    private TextField adresCzytelnika;

    @FXML
    private TextField dataUrodzeniaCzytelnika;

    @FXML
    private TextField nrTelefonuCzytelnika;

    //FXML Książek
    @FXML
    private TextField idKsiazki;

    @FXML
    private TextField tytulKsiazki;

    @FXML
    private TextField rokKsiazki;

    @FXML
    private TextField wydawnictwoKsiazki;

    @FXML
    private TextField nrKsiazki;

    @FXML
    private TextField iloscKsiazki;

    @FXML
    private ComboBox cBoxWyborAutora;

    //FXML Czytelników
    @FXML
    private TextField idWypozyczeniaW;
    @FXML
    private TextField idCzytelnikaW;
    @FXML
    private TextField idKsiazkiW;
    @FXML
    private TextField dataWypozyczeniaW;
    @FXML
    private TextField terminZwrotuWypozyczeniaW;
    @FXML
    private ComboBox cBoxWyborCzytelnika;
    @FXML
    private ComboBox cBoxWyborKsiazki;

    //Tabele
    @FXML
    private TableView tableAutorzy;
    @FXML
    private TableView tableCzytelnicy;
    @FXML
    private TableView tableKsiazki;
    @FXML
    private TableView tableWypozyczenia;

    //Kolumny w tabeli AUTORA
    @FXML
    private TableColumn<Autorzy, String> columnLiczbaPorzadkowaAutorzy;
    @FXML
    private TableColumn<Autorzy, String> columnImieAutora;
    @FXML
    private TableColumn<Autorzy, String> columnNazwiskoAutora;

    //Kolumny w tabeli CZYTELNIKA
    @FXML
    private TableColumn<Czytelnicy, String> columnLiczbaPorzadkowaCzytelnicy;
    @FXML
    private TableColumn<Czytelnicy, String> columnImieCzytelnika;
    @FXML
    private TableColumn<Czytelnicy, String> columnNazwiskoCzytelnika;
    @FXML   
    private TableColumn<Czytelnicy, String> columnAdresCzytelnika;
    @FXML
    private TableColumn<Czytelnicy, String> columnDataCzytelnika;
    @FXML
    private TableColumn<Czytelnicy, String> columnNumerCzytelnika;

    //kolumny w tabeli KSIAZKI
    @FXML
    private TableColumn<Ksiazki, String> columnLiczbaPorzadkowaKsiazki;
    @FXML
    private TableColumn<Ksiazki, String> columnWydawnictwoKsiazki;
    @FXML
    private TableColumn<Ksiazki, String> columnTytulKsiazki;
    @FXML
    private TableColumn<Ksiazki, String> columnRokKsiazki;
    @FXML
    private TableColumn<Ksiazki, String> columnIsbnKsiazki;
    @FXML
    private TableColumn<Ksiazki, String> columnIloscKsiazki;
    @FXML
    private TableColumn<Ksiazki, Integer> columnIdAutoraK;

    //kolumny w tabeli Wypozyczenia
    @FXML
    private TableColumn<Wypozyczenia, Integer> columnIdCzytelnikaW;
    @FXML
    private TableColumn<Wypozyczenia, Integer> columnIdKsiazkiW;
    @FXML
    private TableColumn<Wypozyczenia, String> columnDataWypozyczeniaW;
    @FXML
    private TableColumn<Wypozyczenia, String> columnTerminZwrotuWypozyczeniaW;
    @FXML
    private TableColumn<Wypozyczenia, String> columnLiczbaPorzadkowa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Kolumny Czytelników
        columnLiczbaPorzadkowaCzytelnicy.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Czytelnicy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Czytelnicy, String> p) {
                return new ReadOnlyObjectWrapper(tableCzytelnicy.getItems().indexOf(p.getValue()) + 1 + "");
            }
        });
        columnLiczbaPorzadkowaCzytelnicy.setSortable(false);
        columnImieCzytelnika.setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        columnNazwiskoCzytelnika.setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());
        columnAdresCzytelnika.setCellValueFactory(cellData -> cellData.getValue().adresProperty());
        columnDataCzytelnika.setCellValueFactory(cellData -> cellData.getValue().data_urodzeniaProperty());
        columnNumerCzytelnika.setCellValueFactory(cellData -> cellData.getValue().nr_telefonuProperty());

        //Kolumny Autorów 
        columnLiczbaPorzadkowaAutorzy.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Autorzy, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Autorzy, String> p) {
                return new ReadOnlyObjectWrapper(tableAutorzy.getItems().indexOf(p.getValue()) + 1 + "");
            }
        });
        columnLiczbaPorzadkowaAutorzy.setSortable(false);
        columnImieAutora.setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        columnNazwiskoAutora.setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());

        //Kolumny Wypożyczeń
        //liczba porzadkowa
        columnLiczbaPorzadkowa.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Wypozyczenia, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Wypozyczenia, String> p) {
                return new ReadOnlyObjectWrapper(tableWypozyczenia.getItems().indexOf(p.getValue()) + 1 + "");
            }
        });
        columnLiczbaPorzadkowa.setSortable(false);
        columnIdCzytelnikaW.setCellValueFactory(cellData -> cellData.getValue().id_czytelnikaProperty().asObject());
        columnIdKsiazkiW.setCellValueFactory(cellData -> cellData.getValue().id_ksiazkiProperty().asObject());
        columnDataWypozyczeniaW.setCellValueFactory(cellData -> cellData.getValue().data_wypozyczeniaProperty());
        columnTerminZwrotuWypozyczeniaW.setCellValueFactory(cellData -> cellData.getValue().termin_zwrotuProperty());

        //Kolumny Książek
        columnLiczbaPorzadkowaKsiazki.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Ksiazki, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Ksiazki, String> p) {
                return new ReadOnlyObjectWrapper(tableKsiazki.getItems().indexOf(p.getValue()) + 1 + "");
            }
        });
        columnLiczbaPorzadkowaKsiazki.setSortable(false);
        columnIdAutoraK.setCellValueFactory(cellData -> cellData.getValue().id_autoraProperty().asObject());
        columnWydawnictwoKsiazki.setCellValueFactory(cellData -> cellData.getValue().wydawnictwoProperty());
        columnTytulKsiazki.setCellValueFactory(cellData -> cellData.getValue().tytulProperty());
        columnRokKsiazki.setCellValueFactory(cellData -> cellData.getValue().rokProperty());
        columnIsbnKsiazki.setCellValueFactory(cellData -> cellData.getValue().nr_ksiazkiProperty());
        columnIloscKsiazki.setCellValueFactory(cellData -> cellData.getValue().ilosc_ksiazkiProperty());

        //Wczytywanie Comboboxa z autorami w zakładce ksiazki
        cBoxWyborAutora.setConverter(new StringConverter<Autorzy>() {
            @Override
            public Autorzy fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String toString(Autorzy object) {
                return object.getImie() + " " + object.getNazwisko();
            }
        });
        try {
            cBoxWyborAutora.setItems(AutorzyDAO.wyborAutora());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cBoxWyborAutora.getSelectionModel().select(0);

    
    
    //Wczytywanie Comboboxa z czytelnikami w zakładce wypozyczenia
        cBoxWyborCzytelnika.setConverter(new StringConverter<Czytelnicy>() {
            @Override
            public Czytelnicy fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String toString(Czytelnicy object) {
                return object.getImie() + " " + object.getNazwisko() + ", " + object.getData_urodzenia();
            }
        });
        try {
            cBoxWyborCzytelnika.setItems(CzytelnicyDAO.wyborCzytelnika());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cBoxWyborCzytelnika.getSelectionModel().select(0);
    
        //Wczytywanie Comboboxa z ksiazkami w zakładce wypozyczenia
        cBoxWyborKsiazki.setConverter(new StringConverter<Ksiazki>() {
            @Override
            public Ksiazki fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public String toString(Ksiazki object) {
                return  object.getTytul();
            }
        });
        try {
            cBoxWyborKsiazki.setItems(KsiazkiDAO.wyborKsiazki());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cBoxWyborKsiazki.getSelectionModel().select(0);
    }

    

    //Akcje DODAWANIA -> USUWANIA -> WYSZUKIWANIA -> CZYTELNIKA
    //DODAWANIE CZYTELNIKOW
    @FXML
    private void dodajCzytelnikaAction(ActionEvent event) throws Exception {
        CzytelnicyDAO.dodajCzytelnika(imieCzytelnika.getText(), nazwiskoCzytelnika.getText(), adresCzytelnika.getText(), nrTelefonuCzytelnika.getText(),dataUrodzeniaCzytelnika.getText());
        imieCzytelnika.setText("");
        nazwiskoCzytelnika.setText("");
        adresCzytelnika.setText("");
        nrTelefonuCzytelnika.setText("");
        dataUrodzeniaCzytelnika.setText(""); 
        wyszukajCzytelnikowAction(event);
    }

    // USUWANIE CZYTELNIKOW
    @FXML
    private void usunCzytelnikaAction(ActionEvent event) throws Exception {
        int index = tableCzytelnicy.getSelectionModel().getSelectedIndex();
        ObservableList<Czytelnicy> rezerwacjeData = CzytelnicyDAO.WyszukajCzytelnikow();
        Czytelnicy nrID = rezerwacjeData.get(index);
        int nrid = nrID.getId_czytelnika();
        CzytelnicyDAO.usunCzytelnika(nrid);
        wyszukajCzytelnikowAction(event);
    }

    // WYSZUKIWANIE CZYTELNIKOW
    @FXML
    private void wyszukajCzytelnikowAction(ActionEvent event) throws Exception {
        ObservableList<Czytelnicy> czytelnicyData = CzytelnicyDAO.WyszukajCzytelnikow();
        pokazCzytelnikow(czytelnicyData);

    }

    //Akcje DODAWANIA -> USUWANIA -> WYSZUKIWANIA -> AUTOROW
    //DODAWANIE AUTOROW
    @FXML
    private void dodajAutoraAction(ActionEvent event) throws Exception {

        AutorzyDAO.dodajAutora(imieAutora.getText(), nazwiskoAutora.getText());
        imieAutora.setText("");
        nazwiskoAutora.setText("");
        wyszukajAutorowAction(event);
    }

    //USUWANIE AUTOROW
    @FXML
    private void usunAutoraAction(ActionEvent event) throws Exception {
          int index = tableAutorzy.getSelectionModel().getSelectedIndex();
        ObservableList<Autorzy> rezerwacjeData = AutorzyDAO.WyszukajAutorow();
        Autorzy nrID = rezerwacjeData.get(index);
        int nrid = nrID.getId_autora();
        AutorzyDAO.usunAutora(nrid);
        wyszukajAutorowAction(event);
    }

    //WYSZUKIWANIE AUTOROW
    @FXML
    private void wyszukajAutorowAction(ActionEvent event) throws Exception {
        ObservableList<Autorzy> autorzyData = AutorzyDAO.WyszukajAutorow();
        pokazAutorow(autorzyData);
    }

    //Akcje DODAWANIA -> USUWANIA -> WYSZUKIWANIA -> WYPOZYCZENIA
    //DODAWANIE WYPOZYCZEN
    @FXML
    private void dodajWypozyczeniaAction(ActionEvent event) throws Exception {
        int index = cBoxWyborKsiazki.getSelectionModel().getSelectedIndex();
        Ksiazki wybranyKsiazki = KsiazkiDAO.wyborKsiazki().get(index);
        int index2 = cBoxWyborCzytelnika.getSelectionModel().getSelectedIndex();
        Czytelnicy wybranyCzytelnicy = CzytelnicyDAO.wyborCzytelnika().get(index2);
        WypozyczeniaDAO.dodajWypozyczenia(wybranyKsiazki.getId_ksiazki(),wybranyCzytelnicy.getId_czytelnika(), dataWypozyczeniaW.getText(), terminZwrotuWypozyczeniaW.getText());
        dataWypozyczeniaW.setText("");
        terminZwrotuWypozyczeniaW.setText("");
        cBoxWyborKsiazki.getSelectionModel().select(0);
        cBoxWyborCzytelnika.getSelectionModel().select(0);
        wyszukajWypozyczeniaAction(event);
    }

    //USUWANIE WYPOZYCZEN
    @FXML
    private void usunWypozyczeniaAction(ActionEvent event) throws Exception {
        int index = tableWypozyczenia.getSelectionModel().getSelectedIndex();
        ObservableList<Wypozyczenia> rezerwacjeData = WypozyczeniaDAO.WyszukajWypozyczenia();
        Wypozyczenia nrID = rezerwacjeData.get(index);
        int nrid = nrID.getId_wypozyczenia();
        WypozyczeniaDAO.usunWypozyczenia(nrid);
        wyszukajWypozyczeniaAction(event);

    }

    //WYSZUKIWANIE WYPOZYCZEN
    @FXML
    private void wyszukajWypozyczeniaAction(ActionEvent event) throws Exception {
        ObservableList<Wypozyczenia> wypozyczeniaData = WypozyczeniaDAO.WyszukajWypozyczenia();
        pokazWypozyczenia(wypozyczeniaData);

    }

    //Akcje DODAWANIA -> USUWANIA -> WYSZUKIWANIA -> KSIAZKI
    // DODAWANIE KSIAZKI
    @FXML
    private void dodajKsiazkeAction(ActionEvent event) throws Exception {
        int index = cBoxWyborAutora.getSelectionModel().getSelectedIndex();
        Autorzy wybranyAutor = AutorzyDAO.wyborAutora().get(index);
        KsiazkiDAO.dodajKsiazke(wybranyAutor.getId_autora(), wydawnictwoKsiazki.getText(), tytulKsiazki.getText(), rokKsiazki.getText(), nrKsiazki.getText(), iloscKsiazki.getText());
        wydawnictwoKsiazki.setText("");
        tytulKsiazki.setText("");
        rokKsiazki.setText("");
        nrKsiazki.setText("");
        iloscKsiazki.clear();
//        iloscKsiazki.setText("");
        cBoxWyborAutora.getSelectionModel().select(0);
        wyszukajKsiazkiAction(event);
    }

    //USUWANIE KSIAZKI
    @FXML
    private void usunKsiazkeAction(ActionEvent event) throws Exception {
        int index = tableKsiazki.getSelectionModel().getSelectedIndex();
        ObservableList<Ksiazki> rezerwacjeData = KsiazkiDAO.WyszukajKsiazki();
        Ksiazki nrID = rezerwacjeData.get(index);
        int nrid = nrID.getId_ksiazki();
        KsiazkiDAO.usunKsiazke(nrid);
        wyszukajKsiazkiAction(event);

    }

    //WYSZKIWANIE KSIAZKI
    @FXML
    private void wyszukajKsiazkiAction(ActionEvent event) throws Exception {
        ObservableList<Ksiazki> ksiazkiData = KsiazkiDAO.WyszukajKsiazki();
        pokazKsiazki(ksiazkiData);

    }

    @FXML
    private void pokazAutorow(ObservableList<Autorzy> autorzyData) {
        tableAutorzy.setItems(autorzyData);
    }

    @FXML
    private void pokazCzytelnikow(ObservableList<Czytelnicy> czytelnicyData) {
        tableCzytelnicy.setItems(czytelnicyData);
    }

    @FXML
    private void pokazKsiazki(ObservableList<Ksiazki> ksiazkiData) {
        tableKsiazki.setItems(ksiazkiData);
    }

    @FXML
    private void pokazWypozyczenia(ObservableList<Wypozyczenia> wypozyczeniaData) {
        tableWypozyczenia.setItems(wypozyczeniaData);
    }

}
