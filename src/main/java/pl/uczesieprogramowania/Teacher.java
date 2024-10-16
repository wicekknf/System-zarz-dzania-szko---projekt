package pl.uczesieprogramowania;

import java.util.ArrayList;
import java.util.List;

//obiekt nauczyciel stworzymy rozszerzając klasę abstrakcyjną Person
public class Teacher extends Person{
//    dodatkowymi polami tego obiektu będą obiekt Subject oraz lista uczniów-wychowanków
    private Subject subject;
    List<Student> studentsList =  new ArrayList<>();


    public Teacher(String name, String lastName, String dateOfBirth, Subject subject) {
//      konstruktor będzie się składał z pól klasy, po którje dziedziczymy
        super(name, lastName, dateOfBirth);
//        oraz nowego, który dodaliśmy w tej klasie
        this.subject = subject;
    }

//    aby uzyskać dostęp do "odczytu" Subject dodajmy "getter"
    public Subject getSubject() {
        return subject;
    }

//    żebyśmy mogli przypisać wartość ustawmy "setter"
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

//    metoda, która wypisuje z listy wychowanków przypisanych do nauczyciela
    public void showTeacherStudents () {
        System.out.println("Wychowankowie nauczyciela:");
        for (Student student : studentsList) {
            System.out.print(student.getName() + " ");
            System.out.println(student.getLastName());
            System.out.println();
        }
    }
}
