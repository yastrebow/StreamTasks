package ru.yastrebov.streamtasks.DecisionByStream;

import ru.yastrebov.streamtasks.Person;
import ru.yastrebov.streamtasks.enums.Nationality;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfPeopleDecisionByStreams {
    public static void main(String[] args) {
        Person p1 = new Person(1, "Василий", "Чапаев", "Иванович", 45, Nationality.UKRAINIAN);
        Person p2 = new Person(2, "Василий", "Чапаев", "Иванович", 45, Nationality.UKRAINIAN);
        Person p3 = new Person(3, "Виктор", "Чапаев", "Ипполитович", 37, Nationality.JEW);
        Person p4 = new Person(4, "Сергей", "Иванов", "Владиславович", 37, Nationality.RUSSIAN);
        Person p5 = new Person(5, "Семен", "Рабинович", "Аронович", 56, Nationality.JEW);
        Person p6 = new Person(6, "Арон", "Рабинович", "Моисеевич", 16, Nationality.RUSSIAN);
        Person p7 = new Person(7, "Василий", "Иванов", "Петрович", 37, Nationality.JEW);
        Person p8 = new Person(8, "Василиса", "Иванова", "Сергеевна", 27, Nationality.RUSSIAN);
        Person p9 = new Person(9, "Мария", "Бубка", "Петровна", 17, Nationality.UKRAINIAN);
        Person p10 = new Person(10, "Циля", "Лифшиц", "Соломоновна", 67, Nationality.JEW);
        Person p11 = new Person(11, "Виктория", "Иванова", "Серафимовна", 47, Nationality.RUSSIAN);
        Person p12 = new Person(12, "Цецилия", "Погорелова", "Федоровна", 5, Nationality.RUSSIAN);
        Person p13 = new Person(13, "Василий", "Иванов", "Петрович", 37, Nationality.JEW);
        Person p14 = new Person(14, "Василиса", "Иванова", "Сергеевна", 27, Nationality.RUSSIAN);

        List<Person> tmpListOfPeople = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);

        List<Person> listOfPeople = new ArrayList<>();

        listOfPeople.add(new Person(0, "Василий", "Чапаев", "Иванович", 45, Nationality.UKRAINIAN));

        listOfPeople.addAll(tmpListOfPeople);

//                for(Person person: listOfPeople)  {
//            System.out.println(person.getId() + ". " + person.getName() + " " + person.getPatronymicName() + " " + person.getLastName() + " , " + person.getAge() + " , " + person.getNationality());
//        }
//        peopleOverEighteen(listOfPeople);
//        averageAge(listOfPeople);
//        peopleOfEachNationality(listOfPeople);
//        fullNames(listOfPeople);
//        withInitials(listOfPeople);
//       listByLastname(listOfPeople);
//        uniquePeople(listOfPeople);
//        sortedByLastname(listOfPeople);
//        peopleByNationality(listOfPeople, Nationality.UKRAINIAN);

    }

    public static List<Person> peopleOverEighteen(List<Person> listOfPeople) {

        List<Person> peopleOverEighteen = listOfPeople.stream()
                .filter(a -> a.getAge() > 18)
                .collect(Collectors.toList());

        System.out.println("This people are over 18 years old:");
        for (Person person : peopleOverEighteen)
            System.out.println(person);
        return peopleOverEighteen;
    }

    public static Double averageAge(List<Person> listOfPeople) {

        Double averageAge = listOfPeople.stream()
                .collect(Collectors.averagingDouble((Person::getAge)));

        System.out.println("The average age of people is " + averageAge  + " years old.");
        return averageAge;
    }

    public static Map<String, Integer> peopleOfEachNationality(List<Person> listOfPeople) {

        Map<String, Integer> peopleOfEachNationality = listOfPeople.stream()
                .collect(Collectors.toMap(Person::getNationality, s -> 1, Integer::sum));

        for (Map.Entry entry : peopleOfEachNationality.entrySet()) {
            System.out.println("Nationality: " + entry.getKey() + "; Number of persons: "
                    + entry.getValue());
        }
        return peopleOfEachNationality;
    }

    public static List<String> fullNames(List<Person> listOfPeople) {

        List<String> fullNames = listOfPeople.stream()
                .map(p -> p.getLastName() + " " + p.getName() + " " + p.getPatronymicName())
                .collect(Collectors.toList());

        for (String person : fullNames) {
            System.out.println(person);
        }
        return fullNames;
    }

    public static List<String> withInitials(List<Person> listOfPeople) {

        List<String> withInitials = listOfPeople.stream()
                .map(p -> p.getLastName() + " " + p.getName().charAt(0) + "." + p.getPatronymicName().charAt(0) + ".")
                .collect(Collectors.toList());

        for (String person : withInitials) {
            System.out.println(person);
        }

        return withInitials;
    }

    public static Map<String, List<Person>> listByLastname(List<Person> listOfPeople) {

        Map<String, List<Person>> listByLastname = listOfPeople.stream()
                .collect(Collectors.groupingBy(Person::getLastName));

        for (Map.Entry<String, List<Person>> entry : listByLastname.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        return listByLastname;
    }

    public static List<Person> uniquePeople(List<Person> listOfPeople) {

        List<Person> uniquePeople = listOfPeople.stream()
//                .sorted()
                .distinct()
                .collect(Collectors.toList());

        for (Person person : uniquePeople)
            System.out.println(person);

        return uniquePeople;
    }

    public static List<Person> sortedByLastname(List<Person> listOfPeople) {

        List<Person> sortedByLastname = listOfPeople.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());

        for (Person person : sortedByLastname)
            System.out.println(person);

        return sortedByLastname;
    }

    public static List<Person> peopleByNationality(List<Person> listOfPeople, Nationality nationality) {

        List<Person> peopleByNationality = listOfPeople.stream()
                .filter(p -> p.getNationality().equals(nationality.toString()))
                .collect(Collectors.toList());

        System.out.println("This people are " + nationality + " : ");
        for(Person person:peopleByNationality)
        System.out.println(person);

        return peopleByNationality;
    }
}
