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
public class Autorzy {

    private IntegerProperty id_autora;
    private StringProperty imie;
    private StringProperty nazwisko;

    public Autorzy() {
        this.id_autora = new SimpleIntegerProperty();
        this.imie = new SimpleStringProperty();
        this.nazwisko = new SimpleStringProperty();
    }


    public int getId_autora() {
        return id_autora.get();
    }

    public void setId_autora(int value) {
        id_autora.set(value);
    }

    public IntegerProperty id_autoraProperty() {
        return id_autora;
    }

    public String getImie() {
        return imie.get();
    }

    public void setImie(String value) {
        imie.set(value);
    }

    public StringProperty imieProperty() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public void setNazwisko(String value) {
        nazwisko.set(value);
    }

    public StringProperty nazwiskoProperty() {
        return nazwisko;
    }

}
