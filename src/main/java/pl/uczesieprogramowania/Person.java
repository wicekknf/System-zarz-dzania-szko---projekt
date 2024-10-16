package pl.uczesieprogramowania;

// Stworzyłem klasę abstrakcyjną, którą wykorzystam do tworzenia obiektów, takich jak nauczyciel czy uczeń
public abstract class Person {
/*    zdefiniujmy uniwersalne dla nas pola klasy
   [z odpowiednimi modyfikatorami dostępu - przecież daty urodzin zmienić się nie da :) ]: */
    protected final String name;
    private final String lastName;
    protected final String dateOfBirth;

//    Konstruktor klasy, który później możemy dziedziczyć:
    public Person(String name, String lastName, String dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

//    Metoda, któą wykorzystamy wobec każdego obiektu jak nauczyciel czy uczeń:
    public void infoAboutPerson() {
        System.out.println("Imię: " + name);
        System.out.println("Nazwisko: " + lastName);
        System.out.println("Data urodzenia: " + dateOfBirth);
    }

//    Aby uzyskać dostęp do odczytu pól utwurzmy "gettery"
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
