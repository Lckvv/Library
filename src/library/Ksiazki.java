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
public class Ksiazki {

    private IntegerProperty id_ksiazki;
    private IntegerProperty id_autora;
    private StringProperty wydawnictwo;
    private StringProperty tytul;
    private StringProperty rok_wydania;
    private StringProperty nr_ISBN;
    private StringProperty ilosc_ksiazek;

    public Ksiazki() {
        this.id_ksiazki = new SimpleIntegerProperty();
        this.id_autora = new SimpleIntegerProperty();
        this.wydawnictwo = new SimpleStringProperty();
        this.tytul = new SimpleStringProperty();
        this.rok_wydania = new SimpleStringProperty();
        this.nr_ISBN = new SimpleStringProperty();
        this.ilosc_ksiazek = new SimpleStringProperty();
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
    public IntegerProperty id_autoraProperty() {
        return id_autora;
    }

    public int getId_autora() {
        return id_autora.get();
    }

    public void setId_autora(int value) {
        id_autora.set(value);
    }

    public String getWydawnictwo() {
        return wydawnictwo.get();
    }

    public void setWydawnictwo(String value) {
        wydawnictwo.set(value);
    }
    public StringProperty wydawnictwoProperty() {
        return wydawnictwo;
    }

    public String getTytul() {
        return tytul.get();
    }

    public void setTytul(String value) {
        tytul.set(value);
    }
    public StringProperty tytulProperty() {
        return tytul;
    }

    public String getRok_wydania() {
        return rok_wydania.get();
    }

    public void setRok_wydania(String value) {
        rok_wydania.set(value);
    }
    public StringProperty rokProperty() {
        return rok_wydania;
    }

    public String getNr_ISBN() {
        return nr_ISBN.get();
    }

    public void setNr_ISBN(String value) {
        nr_ISBN.set(value);
    }
    public StringProperty nr_ksiazkiProperty() {
        return nr_ISBN;
    }

    public String getIlosc_ksiazek() {
        return ilosc_ksiazek.get();
    }

    public void setIlosc_ksiazek(String value) {
        ilosc_ksiazek.set(value);
    }
    public StringProperty ilosc_ksiazkiProperty() {
        return ilosc_ksiazek;
    }
    
    
    
    
    
}
