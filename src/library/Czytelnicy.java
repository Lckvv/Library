package library;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Lucek
 */
public class Czytelnicy {

    private IntegerProperty id_czytelnika;
    private StringProperty adres;
    private StringProperty imie;
    private StringProperty nazwisko;
    private StringProperty nr_telefonu;
    private StringProperty data_urodzenia;

    public Czytelnicy() {
        this.id_czytelnika = new SimpleIntegerProperty();
        this.adres = new SimpleStringProperty();
        this.imie = new SimpleStringProperty();
        this.nazwisko = new SimpleStringProperty();
        this.nr_telefonu = new SimpleStringProperty();
        this.data_urodzenia = new SimpleStringProperty();
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

    public String getNr_telefonu() {
        return nr_telefonu.get();
    }

    public void setNr_telefonu(String value) {
        nr_telefonu.set(value);
    }

    public StringProperty nr_telefonuProperty() {
        return nr_telefonu;
    }

    public String getData_urodzenia() {
        return data_urodzenia.get();
    }

    public void setData_urodzenia(String value) {
        data_urodzenia.set(value);
    }

    public StringProperty data_urodzeniaProperty() {
        return data_urodzenia;
    }

    public String getAdres() {
        return adres.get();
    }

    public void setAdres(String value) {
        adres.set(value);
    }

    public StringProperty adresProperty() {
        return adres;
    }

}
