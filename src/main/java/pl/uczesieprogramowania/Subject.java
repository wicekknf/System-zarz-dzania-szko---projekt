package pl.uczesieprogramowania;

// klasa, która stworzy nam obiekt Subject
public class Subject {
//    pola klasy, których użyjemy do stworzenia objektu przedmiot
    private String nazwa;
    private String opis;

//    konstruktor, do tworzenia obiektu przedmiot
    public Subject (String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa (String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void infoAboutSubject() {
        System.out.println("Przedniot: " + nazwa);
        System.out.println("Opis przedmiotu: " + opis);
    }
}
