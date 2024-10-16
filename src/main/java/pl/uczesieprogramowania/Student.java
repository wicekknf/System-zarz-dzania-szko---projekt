package pl.uczesieprogramowania;

// klasa, która tworzy obiekt Student dziedzicząc po klasie Person
public class Student extends Person{
//    pole klasy
    private String groupClass;

//    konstruktor, w którym korzystamy z pól klasy Person
    public Student(String name, String lastName, String dateOfBirth, String groupClass) {
        super(name, lastName, dateOfBirth);
        this.groupClass = groupClass;
    }

//    aby mieć dostęp do odczytu i przypisania tworzymy odpowiednio "getter" oraz "setter"
    public String getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(String groupClass) {
        this.groupClass = groupClass;
    }


}
