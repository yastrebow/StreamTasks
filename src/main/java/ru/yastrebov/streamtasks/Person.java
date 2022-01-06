package ru.yastrebov.streamtasks;

import ru.yastrebov.streamtasks.enums.Nationality;
import java.util.Objects;

public class Person implements Comparable{
   private final Integer id;
   private final String name;
   private final String lastName;
   private final String patronymicName;
   private final Integer age;
   private final Nationality nationality;

    public Person(Integer id, String name, String lastName, String patronymicName, Integer age, Nationality nationality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.patronymicName = patronymicName;
        this.age = age;
        this.nationality = nationality;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public Integer getAge() { return age; }

    public String getNationality() { return nationality.toString(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getLastName().equals(person.getLastName()) && getPatronymicName().equals(person.getPatronymicName()) && getAge().equals(person.getAge()) && getNationality() == person.getNationality();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getPatronymicName(), getAge(), getNationality());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", age=" + age +
                ", nationality=" + nationality +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
