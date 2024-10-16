package pl.uczesieprogramowania;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        /* W kodzie znajdują się nazwy po polsku. Wyjątkowo w tym projekcie zastosowałem taką metodę.
        Takie praktyki "polish-english" są niedopuszczalne i na co dzień ich nie stosuję.
        Kod powinien w całości zawierać nazwy po angielsku. */



//  stworzenie zmiennych potrzebnych w programie

        boolean loop = true;
        int przedmiotDoNauczania = 0;
        int uczenDoUsuniecia = -1;
        int nauczycielDoUsuniecia = -1;

//  tworzenie list na użytek programu

        List<Subject> listaPrzedmiotow = new ArrayList<>();
        List<Student> listaUczniow = new ArrayList<>();
        List<Teacher> listaNauczycieli = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

//        utowrzenie głównej pętli programu do przyjmowania komend od użytkownika
//        oraz zwracania informacji

//        Na początku program zada pytania, co użytkownik chce zrobić:

        while (loop) {
            int indeksNauczyciela = -1;
            int indeksUcznia = -1;
            System.out.println("Co chcesz zrobić, napisz cyfrę od 1 do 11:");
            System.out.println("1. Dodaj przedmiot:");
            System.out.println("2. Dodaj nauczyciela do listy:");
            System.out.println("3. Usuń nauczyciela z listy");
            System.out.println("4. Dodaj ucznia do listy");
            System.out.println("5. Usuń ucznia z listy");
            System.out.println("6. Wyświetl wszystkie przedmioty na liście");
            System.out.println("7. Wyświetl wszystkich nauczycieli z listy");
            System.out.println("8. Wyświetl wszystkich uczniów z listy");
            System.out.println("9. Przypisz nauczycielowi wychowanka");
            System.out.println("10. Wyświetl wychowanków nauczyliela");
            System.out.println("11. Wyjdź");

//            linijka poniżej oznacza, że program zapisze w zmiennej "wybór" informację od użytkownika:
            String wybor = scanner.nextLine();


//            instrukcje warunkowe poniżej w zależności od wyboru użytkownika (cyfry od 1 do 11)
//            poprowadzą program dalej

            if (wybor.equals("1")) {
                System.out.println("Podaj nazwę przedmiotu:");

//                pozyskiwanie danych od użytkownika zgodnie z wyborem:

                String nazwaPrzedmiotu = scanner.nextLine();

                System.out.println("Podaj opis przedmiotu:");
                String opisPrzedmiotu = scanner.nextLine();

//                tworzenie obiektu przedmiot
                Subject subject = new Subject(nazwaPrzedmiotu, opisPrzedmiotu);
                listaPrzedmiotow.add(subject);

//                informacja zwrotna od programu dla użytkownika

                System.out.println("Przedmiot " + subject.getNazwa() + " dodany do listy przedmiotów");


            } else if (wybor.equals("2")) {

//                po wyborze nr 2 tworzymy zmienną, która nam pomoże sprawdzić czy lista przedmiotów jest pusta

                boolean czyJestPrzedmiot = false;
                System.out.println("Jakiego przedmiotu nauczyciel ma uczyć?");
//                przypisujemy do zmiennej nazwę przedmiotu podaną przez użytkownika
                String przedmiotNauczyciela = scanner.nextLine();

//                sprawdzamy, czy przedmiot znajduje się na liście

                for (Subject przedmiotCzyJest : listaPrzedmiotow) {
                    if (przedmiotCzyJest.getNazwa().equals(przedmiotNauczyciela)) {
                        czyJestPrzedmiot = true;
                        przedmiotDoNauczania = listaPrzedmiotow.indexOf(przedmiotCzyJest);
                    }
                }

//                w zależności od tego czy przedmiot znajduje się na liście program pozwala dodać nauczyciela

                if (czyJestPrzedmiot) {
                    System.out.println("Podaj imię nauczyciela:");
                    String nameOfTeacher = scanner.nextLine();

                    System.out.println("Podaj nazwisko nauczyciela:");
                    String lastNameOfTeacher = scanner.nextLine();

                    System.out.println("Podaj datę urodzenia nauczyciela (dd-mm-rr):");
                    String dateOfBirthTeacher = scanner.nextLine();

//                    na podstawie danych od użytkownika powyżej tworzymy obiekt nauczyciel i dodajemy go do listy

                    Teacher teacher = new Teacher(nameOfTeacher, lastNameOfTeacher, dateOfBirthTeacher, listaPrzedmiotow.get(przedmiotDoNauczania));

                    listaNauczycieli.add(teacher);
                    System.out.println("Nauczyciel: " + teacher.getName() + " został dodany do listy.");

                } else {

//                    jeśli lista przedmiotów jest pusta program nie pozwoli stworzyć obiektu nauczyciel
//                    i wyświetli komunikat:

                    System.out.println("Nie ma takiego przedmiotu. Proszę dodaj najpierw przedmiot.");
                }

            } else if (wybor.equals("3")) {
                System.out.println("Podaj imię nauczyciela do usunięcia:");
                String nameTeacherToDelete = scanner.nextLine();

                System.out.println("Podaj nazwisko nauczyciela do usunięcia:");
                String lastNameTecherToDelete = scanner.nextLine();

//                na podstawie danych od użytkownika powyżej program usuwa nauczyciela z listy:

                for (Teacher teacher : listaNauczycieli) {
                    if (teacher.getName().equals(nameTeacherToDelete) && teacher.getLastName().equals(lastNameTecherToDelete)) {
//                        uzyskuję indeks nauczyciela do usunięcia
                        nauczycielDoUsuniecia = listaNauczycieli.indexOf(teacher);
                    }
                }
//                na podstawie uzyskanego indeksu w liście program usuwa odpowiedniego nauczyciela:

                if (nauczycielDoUsuniecia >= 0) {
                    Teacher teacher = listaNauczycieli.get(nauczycielDoUsuniecia);
                    listaNauczycieli.remove(teacher);
                    System.out.println("Nauczyciel " + teacher.getName() + " " + teacher.getLastName() + " został usunięty z listy");
                } else {

//                    jeżeli program nie znajdzie nauczyciela na liście wyświetla odpowiedni komunikat

                    System.out.println("Nie ma takiego nauczyciela na liście.");
                }
            } else if (wybor.equals("4")) {

//                program prosi o odpowiednie dane w celu stworzenia obiektu uczeń

                System.out.println("Podaj imię ucznia:");
                String studentName = scanner.nextLine();

                System.out.println("Podaj nazwisko ucznia:");
                String studentLastName = scanner.nextLine();

                System.out.println("Podaj datę urodzenia (dd-mm-rr):");
                String studentDateOfBirth = scanner.nextLine();

                System.out.println("Podaj klasę ucznia:");
                String studentClass = scanner.nextLine();

//                na podstawie podanych danych program tworzy obiekt uczeń za pomocą konstruktora

                Student student = new Student(studentName, studentLastName, studentDateOfBirth, studentClass);
                listaUczniow.add(student);
                System.out.println("Uczeń " + student.getName() + " " + student.getLastName() + " został dodany do listy");

            } else if (wybor.equals("5")) {

//                Program oczekuje od użytkownika danych w celu usunięcia obiektu uczeń z listy:

                System.out.println("Podaj imię ucznia do usunięcia:");
                String nameStudentToDelete = scanner.nextLine();

                System.out.println("Podaj nazwisko ucznia do usunięcia:");
                String lastNameStudentToDelete = scanner.nextLine();

//              Na podstawie danych program iteruje po liście w celu uzyskania nr indeksu odpowiedniego ucznia na liście:

                for (Student student : listaUczniow) {
                    if (student.getName().equals(nameStudentToDelete) && student.getLastName().equals(lastNameStudentToDelete)) {

//                        Program usuwa obiekt uczeń z listy na podstawie indeksu uzyskanego wyżej (wykorzystuję zmienną zadeklarowaną wcześniej):

                        uczenDoUsuniecia = listaUczniow.indexOf(student);
                    }
                }
                if (uczenDoUsuniecia >= 0) {
                    Student student = listaUczniow.get(uczenDoUsuniecia);
                    listaUczniow.remove(student);
                    System.out.println("Uczeń " + student.getName() + " " + student.getLastName() + " został usunięty z listy.");
                } else {
                    System.out.println("Nie ma takiego ucznia na liście");
                }

//                Poniżej program iteruje po liście przedmiotów wypisując iformacje o nazwie i opisie każdego przedmiotu:

            } else if (wybor.equals("6")) {
                for (Subject subject : listaPrzedmiotow) {
                    System.out.println("Przedmiot: " + subject.getNazwa());
                    System.out.println("Opis przedmiotu: " + subject.getOpis());
                    System.out.println();
                }

//                program iteruje po liście nauczycieli wypisując informacje o nauczycielach z listy:

            }else if (wybor.equals("7")) {
                for (Teacher teacher : listaNauczycieli) {
                    System.out.println("Nauczyciel:");
                    teacher.infoAboutPerson();
                    System.out.println("Nauczany przedmiot: " + teacher.getSubject().getNazwa());
                    System.out.println();
                }

//                program iteruje po liście uczniów wypisując informacje o każdym obiekcie na liście:

            } else if (wybor.equals("8")) {
                for (Student student : listaUczniow) {
                    System.out.println("Uczeń:");
                    student.infoAboutPerson();
                    System.out.println("Klasa: " + student.getGroupClass());
                    System.out.println();
                }


            } else if (wybor.equals("9")) {

//                program sprawdza, czy listy nauczycieli i uczniów nie są puste:

                if (!listaNauczycieli.isEmpty() && !listaUczniow.isEmpty()) {

                        System.out.println("Podaj imie nauczyciela:");
                        String imieNauczycielaWychowawcy = scanner.nextLine();

                        System.out.println("Podaj nazwisko nauczyciela:");
                        String nazwiskoNauczycielaWychowawcy = scanner.nextLine();

//                        program uzyskuje indeks obiektu nauczyciel wyznaczonego do przypisania wychowanka:

                        for (Teacher teacher : listaNauczycieli) {
                            if (teacher.getName().equals(imieNauczycielaWychowawcy) && teacher.getLastName().equals(nazwiskoNauczycielaWychowawcy)) {
                                indeksNauczyciela = listaNauczycieli.indexOf(teacher);
                            } else {
                                System.out.println("Nie ma takiego nauczyciela na liście.");
                            }
                        }
                        System.out.println("Podaj imię ucznia:");
                        String imieUczniaWychowanka = scanner.nextLine();

                        System.out.println("Podaj nazwisko ucznia wychowanka:");
                        String nazwiskoUczniaWychowanka = scanner.nextLine();

//                        program uzyskuje indeks obiektu uczeń przeznaczonego do przypisania jako wychowanek:

                        for (Student student : listaUczniow) {
                            if (student.getName().equals(imieUczniaWychowanka) && student.getLastName().equals(nazwiskoUczniaWychowanka)) {
                                indeksUcznia = listaUczniow.indexOf(student);
                            } else {
                                System.out.println("Nie ma takiego ucznia na liście");
                            }

//                            program sprawdza, czy udało się znaleźć odpowiednie obiekty:

                            if (indeksUcznia > -1 && indeksNauczyciela > -1) {
                                Teacher nauczycielWychowawca = listaNauczycieli.get(indeksNauczyciela);
                                Student uczenWychowanek = listaUczniow.get(indeksUcznia);

//                                na podstawie wyżej uzyskanych danych program dodaje do listy odpowiedniego obiektu nauczyciel
//                                odpowiedni obiekt uczeń

                                nauczycielWychowawca.studentsList.add(uczenWychowanek);
                                System.out.println("Uczeń " + uczenWychowanek.getName() + " " + uczenWychowanek.getLastName() + " został przypisany do listy wychowanków nauczyciela " + nauczycielWychowawca.getName() + " " + nauczycielWychowawca.getLastName());
                            } else {
                                System.out.println("Uzupełnij listę o brakującą osobę (nauczyciel lub uczeń) i przypisz wychowanka/wychowankę ponownie");
                            }
                        }
                } else {
                    System.out.println("Lista uczniów lub nauczycieli jest pusta. Sprawdź listy.");
                }

            } else if (wybor.equals("10")) {
                System.out.println("Podaj imię nauczyciela wychowawcę:");
                String imieNauczycielaWychowawcy = scanner.nextLine();

                System.out.println("Podaj nazwisko nauczyciela wychowawcy:");
                String nazwiskoNauczycielaWychowawcy = scanner.nextLine();

                for (Teacher teacher : listaNauczycieli) {

//                    na podstawie wyżej podanych danych przez użytkownika program szuka indeku obiektu nauczyciel na liście:

                    if (teacher.getName().equals(imieNauczycielaWychowawcy) && teacher.getLastName().equals(nazwiskoNauczycielaWychowawcy)) {
                        indeksNauczyciela = listaNauczycieli.indexOf(teacher);
                    } else {
                        System.out.println("Nie ma takiego nauczyciela na liście");
                    }
                    if (indeksNauczyciela > -1) {

//                        wykorzystując wyżej uzyskany indeks obiektu nauczyciel program wywołuje metodę danego obiektu
//                        w celu wypisania listy wychowanków

                        Teacher nauczycielWychowawca = listaNauczycieli.get(indeksNauczyciela);
                        nauczycielWychowawca.showTeacherStudents();
                    }
                }

            } else if (wybor.equals("11")) {

//                wybranie tej liczby powoduje wyjście z programu

                loop = false;
            }
        }
    }
}