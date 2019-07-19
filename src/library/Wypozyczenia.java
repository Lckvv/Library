/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author Lucek
 */
public class Wypozyczenia {
    private IntegerProperty id_wypozyczenia;
    private IntegerProperty id_czytelnika;
    private IntegerProperty id_ksiazki;
    private StringProperty data_wypozyczenia;
    private StringProperty termin_zwrotu;

    public Wypozyczenia() {
        this.id_wypozyczenia = new SimpleIntegerProperty();
        this.id_czytelnika = new SimpleIntegerProperty();
        this.id_ksiazki = new SimpleIntegerProperty();
        this.data_wypozyczenia = new SimpleStringProperty();
        this.termin_zwrotu = new SimpleStringProperty();
    }

    public int getId_wypozyczenia() {
        return id_wypozyczenia.get();
    }

    public void setId_wypozyczenia(int value) {
        id_wypozyczenia.set(value);
    }
    public IntegerProperty id_wypozyczeniaProperty() {
        return id_wypozyczenia;
    }

    public int getId_czytelnika() {
        return id_czytelnika.get();
    }

    public void setId_czytelnika(int value) {
        id_czytelnika.set(value);
    }
    public IntegerProperty id_czytelnikaProperty() {
        return id_czytelnika;
    }

    public int getId_ksiazki() {
        return id_ksiazki.get();
    }

    public void setId_ksiazki(int value) {
        id_ksiazki.set(value);
    }
    public IntegerProperty id_ksiazkiProperty() {
        return id_ksiazki;
    }

    public String getData_wypozyczenia() {
        return data_wypozyczenia.get();
    }

    public void setData_wypozyczenia(String value) {
        data_wypozyczenia.set(value);
    }
    public StringProperty data_wypozyczeniaProperty() {
        return data_wypozyczenia;
    }

    public String getTermin_zwrotu() {
        return termin_zwrotu.get();
    }

    public void setTermin_zwrotu(String value) {
        termin_zwrotu.set(value);
    }
    public StringProperty termin_zwrotuProperty() {
        return termin_zwrotu;
    }
    
    
   
    
    
}
