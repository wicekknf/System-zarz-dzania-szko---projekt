package pl.uczesieprogramowania;

import java.util.*;

public class Main {
    public static void main(String[] args) {

// stworzenie zmiennych potrzebnych w programie

        boolean loop = true;
        int przedmiotDoNauczania = 0;
        int uczenDoUsuniecia = -1;
        int nauczycielDoUsuniecia = -1;



        List<Subject> listaPrzedmiotow = new ArrayList<>();
        List<Student> listaUczniow = new ArrayList<>();
        List<Teacher> listaNauczycieli = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

//        utowrzenie głównej pętli programu do przyjmowania komend od użytkownika
//        oraz zwracania informacji

        while (loop) {
            int indeksNauczyciela = -1;
            int indeksUcznia = -1;
            System.out.println("Podaj co chcesz zrobić:");
            System.out.println("1. Dodaj przedmiot:");
            System.out.println("2. Usuń przedmiot:");
            System.out.println("3. Dodaj nauczyciela do listy:");
            System.out.println("4. Usuń nauczyciela z listy");
            System.out.println("5. Dodaj ucznia do listy");
            System.out.println("6. Usuń ucznia z listy");
            System.out.println("7. Wyświetl wszystkie przedmioty na liście");
            System.out.println("8. Wyświetl wszystkich nauczycieli z listy");
            System.out.println("9. Wyświetl wszystkich uczniów z listy");
            System.out.println("10. Przypisz nauczycielowi przedmiot");
            System.out.println("11. Przypisz nauczycielowi wychowanka");
            System.out.println("12. Wyświetl wychowanków nauczyliela");
            System.out.println("13. Usuń wychowanka nauczycielowi");
            System.out.println("14. Wyjdź");

            String wybor = scanner.nextLine();

            if (wybor.equals("1")) {
                System.out.println("Podaj nazwę przedmiotu:");
                String nazwaPrzedmiotu = scanner.nextLine();

                System.out.println("Podaj opis przedmiotu:");
                String opisPrzedmiotu = scanner.nextLine();

                Subject subject = new Subject(nazwaPrzedmiotu, opisPrzedmiotu);
                listaPrzedmiotow.add(subject);
                System.out.println("Przedmiot " + subject.getNazwa() + " dodany do listy przedmiotów");

            } else if (wybor.equals("2")) {
                System.out.println("Podaj przedmiot do usunięcia:");
                String subjectToDelete = scanner.nextLine();

                for (Subject subject : listaPrzedmiotow) {
                    if (subject.getNazwa().equals(subjectToDelete)){
                        for (Teacher teacher : listaNauczycieli) {
                            if (teacher.getSubject().equals(subjectToDelete)) {
                                System.out.println("Nie można usunąć przedmiotu. Przedmiot Jest nauczany przez nauczyciela:" + teacher.getName() + " " + teacher.getLastName());
                            } else {
                                listaPrzedmiotow.remove(subject);
                            }
                        }
                    } else {
                        System.out.println("Nie ma takiego przedmiotu na liście.");
                    }
                }




            } else if (wybor.equals("3")) {
                boolean czyJestPrzedmiot = false;
                System.out.println("Jakiego przedmiotu nauczyciel ma uczyć?");
                String przedmiotNauczyciela = scanner.nextLine();

                for (Subject przedmiotCzyJest : listaPrzedmiotow) {
                    if (przedmiotCzyJest.getNazwa().equals(przedmiotNauczyciela)) {
                        czyJestPrzedmiot = true;
                        przedmiotDoNauczania = listaPrzedmiotow.indexOf(przedmiotCzyJest);
                    }
                }
                if (czyJestPrzedmiot) {
                    System.out.println("Podaj imię nauczyciela:");
                    String nameOfTeacher = scanner.nextLine();

                    System.out.println("Podaj nazwisko nauczyciela:");
                    String lastNameOfTeacher = scanner.nextLine();

                    System.out.println("Podaj datę urodzenia nauczyciela:");
                    String dateOfBirthTeacher = scanner.nextLine();

                    Teacher teacher = new Teacher(nameOfTeacher, lastNameOfTeacher, dateOfBirthTeacher, listaPrzedmiotow.get(przedmiotDoNauczania));

                    listaNauczycieli.add(teacher);
                    System.out.println("Nauczyciel: " + teacher.getName() + " został dodany do listy.");

                } else {
                    System.out.println("Nie ma takiego przedmiotu. Proszę dodaj najpierw przedmiot.");
                }

            } else if (wybor.equals("4")) {
                System.out.println("Podaj imię nauczyciela do usunięcia:");
                String nameTeacherToDelete = scanner.nextLine();

                System.out.println("Podaj nazwisko nauczyciela do usunięcia:");
                String lastNameTecherToDelete = scanner.nextLine();

                for (Teacher teacher : listaNauczycieli) {
                    if (teacher.getName().equals(nameTeacherToDelete) && teacher.getLastName().equals(lastNameTecherToDelete)) {
                        nauczycielDoUsuniecia = listaNauczycieli.indexOf(teacher);
                    }
                }
                if (nauczycielDoUsuniecia >= 0) {
                    Teacher teacher = listaNauczycieli.get(nauczycielDoUsuniecia);
                    listaNauczycieli.remove(teacher);
                    System.out.println("Nauczyciel " + teacher.getName() + " " + teacher.getLastName() + " został usunięty z listy");
                } else {
                    System.out.println("Nie ma takiego nauczyciela na liście.");
                }
            } else if (wybor.equals("5")) {
                System.out.println("Podaj imię ucznia:");
                String studentName = scanner.nextLine();

                System.out.println("Podaj nazwisko ucznia:");
                String studentLastName = scanner.nextLine();

                System.out.println("Podaj datę urodzenia:");
                String studentDateOfBirth = scanner.nextLine();

                System.out.println("Podaj klasę ucznia:");
                String studentClass = scanner.nextLine();

                Student student = new Student(studentName, studentLastName, studentDateOfBirth, studentClass);
                listaUczniow.add(student);
                System.out.println("Uczeń " + student.getName() + " " + student.getLastName() + " został dodany do listy");

            } else if (wybor.equals("6")) {
                System.out.println("Podaj imię ucznia do usunięcia:");
                String nameStudentToDelete = scanner.nextLine();

                System.out.println("Podaj nazwisko ucznia do usunięcia:");
                String lastNameStudentToDelete = scanner.nextLine();

                for (Student student : listaUczniow) {
                    if (student.getName().equals(nameStudentToDelete) && student.getLastName().equals(lastNameStudentToDelete)) {
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
            } else if (wybor.equals("7")) {
                for (Subject subject : listaPrzedmiotow) {
                    System.out.println("Przedmiot: " + subject.getNazwa());
                    System.out.println("Opis przedmiotu: " + subject.getOpis());
                    System.out.println();
                }
            }else if (wybor.equals("8")) {
                for (Teacher teacher : listaNauczycieli) {
                    System.out.println("Nauczyciel:");
                    teacher.infoAboutPerson();
                    System.out.println("Nauczany przedmiot: " + teacher.getSubject().getNazwa());
                    System.out.println();
                }
            } else if (wybor.equals("9")) {
                for (Student student : listaUczniow) {
                    System.out.println("Uczeń:");
                    student.infoAboutPerson();
                    System.out.println("Klasa: " + student.getGroupClass());
                    System.out.println();
                }
            } else if (wybor.equals("10")) {
                System.out.println("Podaj imię nauczyciela, którego przedmiot ma zostać zmieniony:");
                String nameTeacherToChange = scanner.nextLine();

                System.out.println("Podaj nazwisko nauczyciela, którego przedmiat ma zostać zmieniony:");
                String lastNameTeacherToChange = scanner.nextLine();

                System.out.println("Podaj nowy przedmiot do nauczania");
                String subjectToChange = scanner.nextLine();

                for (Teacher teacher : listaNauczycieli) {
                    if (teacher.name.equals(nameTeacherToChange) && teacher.getLastName().equals(lastNameTeacherToChange)) {
                        for (Subject subject : listaPrzedmiotow) {
                            if (subject.getNazwa().equals(subjectToChange)) {
                                teacher.setSubject(subject);
                            } else {
                                System.out.println("Nie ma takiego przedmiotu na liście");
                            }
                        }
                    } else {
                        System.out.println("Nie ma takiego nauczyciela na liście");
                    }
                }

            } else if (wybor.equals("11")) {
                if (!listaNauczycieli.isEmpty() && !listaUczniow.isEmpty()) {

                        System.out.println("Podaj imie nauczyciela:");
                        String imieNauczycielaWychowawcy = scanner.nextLine();

                        System.out.println("Podaj nazwisko nauczyciela:");
                        String nazwiskoNauczycielaWychowawcy = scanner.nextLine();

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

                        for (Student student : listaUczniow) {
                            if (student.getName().equals(imieUczniaWychowanka) && student.getLastName().equals(nazwiskoUczniaWychowanka)) {
                                indeksUcznia = listaUczniow.indexOf(student);
                            } else {
                                System.out.println("Nie ma takiego ucznia na liście");
                            }
                            if (indeksUcznia > -1 && indeksNauczyciela > -1) {
                                Teacher nauczycielWychowawca = listaNauczycieli.get(indeksNauczyciela);
                                Student uczenWychowanek = listaUczniow.get(indeksUcznia);

                                nauczycielWychowawca.studentsList.add(uczenWychowanek);
                                System.out.println("Uczeń " + uczenWychowanek.getName() + " " + uczenWychowanek.getLastName() + " został przypisany do listy wychowanków nauczyciela " + nauczycielWychowawca.getName() + " " + nauczycielWychowawca.getLastName());
                            } else {
                                System.out.println("Uzupełnij listę o brakującą osobę (nauczyciel lub uczeń) i nadaj wychowawsto ponownie");
                            }
                        }
                } else {
                    System.out.println("Lista uczniów lub nauczycieli jest pusta. Sprawdź listy.");
                }

            } else if (wybor.equals("12")) {
                System.out.println("Podaj imię nauczyciela wychowawcę:");
                String imieNauczycielaWychowawcy = scanner.nextLine();

                System.out.println("Podaj nazwisko nauczyciela wychowawcy:");
                String nazwiskoNauczycielaWychowawcy = scanner.nextLine();

                for (Teacher teacher : listaNauczycieli) {
                    if (teacher.getName().equals(imieNauczycielaWychowawcy) && teacher.getLastName().equals(nazwiskoNauczycielaWychowawcy)) {
                        indeksNauczyciela = listaNauczycieli.indexOf(teacher);
                    } else {
                        System.out.println("Nie ma takiego nauczyciela na liście");
                    }
                    if (indeksNauczyciela > -1) {
                        Teacher nauczycielWychowawca = listaNauczycieli.get(indeksNauczyciela);
                        nauczycielWychowawca.showTeacherStudents();
                    }
                }
            } else if (wybor.equals("13")) {
                System.out.println("Podaj imię nauczyciela wychowawcę:");
                String imieNauczycielaWychowawcy = scanner.nextLine();

                System.out.println("Podaj nazwisko nauczyciela wychowawcy:");
                String nazwiskoNauczycielaWychowawcy = scanner.nextLine();

                for (Teacher teacher : listaNauczycieli) {
                    if (teacher.getName().equals(imieNauczycielaWychowawcy) && teacher.getLastName().equals(nazwiskoNauczycielaWychowawcy)) {
                        indeksNauczyciela = listaNauczycieli.indexOf(teacher);
                    } else {
                        System.out.println("Nie ma takiego nauczyciela na liście");
                    }
                    if (indeksNauczyciela > -1) {
                        Teacher nauczycielWychowawca = listaNauczycieli.get(indeksNauczyciela);

                        System.out.println("Podaj imię ucznia do usunięcia z listy wychowanków");
                        String imieWychowanekDoUsuniecia = scanner.nextLine();

                        System.out.println("Podaj nazwisko ucznia do usunięcia z listy wychowanków:");
                        String nazwiskoWychowanekDoUsuniecia = scanner.nextLine();

                        for (Student student : nauczycielWychowawca.studentsList) {
                            if (student.getName().equals(imieWychowanekDoUsuniecia) && student.getLastName().equals(nazwiskoWychowanekDoUsuniecia)) {
                                indeksUcznia = nauczycielWychowawca.studentsList.indexOf(student);
                            } else {
                                System.out.println("Nie ma takiego ucznia na liście");
                            }
                        }
                            if (indeksUcznia > -1) {
                                Student uczenDoUsunieciaWychowanek = nauczycielWychowawca.studentsList.get(indeksUcznia);
                                nauczycielWychowawca.studentsList.remove(uczenDoUsunieciaWychowanek);
                                System.out.println("Uczeń " + uczenDoUsunieciaWychowanek.getName() + " " + uczenDoUsunieciaWychowanek.getLastName() + " został usunięty z listy wychowanków nauczyciela " + nauczycielWychowawca.getName() + " " + nauczycielWychowawca.getLastName());
                            } else {
                                System.out.println("Upewnij się czy poprawnie wprowadziłeś dane ucznia lub czy uczeń znajduje się na liście wychowanków nauczyciela");
                            }
                    } else {
                        System.out.println("Upewnij się czy chodziło o podanego nauczyciela.");
                    }
                }
            } else if (wybor.equals("14")) {
                loop = false;
            }
        }
    }
}