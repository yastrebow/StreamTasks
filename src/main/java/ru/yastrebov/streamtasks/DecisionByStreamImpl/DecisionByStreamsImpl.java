package ru.yastrebov.streamtasks.DecisionByStreamImpl;

import ru.yastrebov.streamtasks.Decision;
import ru.yastrebov.streamtasks.Person;
import ru.yastrebov.streamtasks.enums.Nationality;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DecisionByStreamsImpl implements Decision {
    public static void main(String[] args) {

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
@Override
    public List<Person> peopleOverEighteen(List<Person> listOfPeople) {

        List<Person> peopleOverEighteen = listOfPeople.stream()
                .filter(a -> a.getAge() > 18)
                .collect(Collectors.toList());

        System.out.println("This people are over 18 years old:");
        for (Person person : peopleOverEighteen)
            System.out.println(person);
        return peopleOverEighteen;
    }
@Override
    public Double averageAge(List<Person> listOfPeople) {

        Double averageAge = listOfPeople.stream()
                .collect(Collectors.averagingDouble((Person::getAge)));

        System.out.println("The average age of people is " + averageAge  + " years old.");
        return averageAge;
    }

    @Override
    public Map<String, Integer> peopleOfEachNationality(List<Person> listOfPeople) {

        Map<String, Integer> peopleOfEachNationality = listOfPeople.stream()
                .collect(Collectors.toMap(person -> person.getNationality().name(), s -> 1, Integer::sum));

        for (Map.Entry entry : peopleOfEachNationality.entrySet()) {
            System.out.println("Nationality: " + entry.getKey() + "; Number of persons: "
                    + entry.getValue());
        }
        return peopleOfEachNationality;
    }

    @Override
    public List<String> fullNames(List<Person> listOfPeople) {

        List<String> fullNames = listOfPeople.stream()
                .map(p -> p.getName() + " " + p.getPatronymicName() + " " + p.getLastName())
                .collect(Collectors.toList());

        for (String person : fullNames) {
            System.out.println(person);
        }
        return fullNames;
    }

    @Override
    public List<String> withInitials(List<Person> listOfPeople) {

        List<String> withInitials = listOfPeople.stream()
                .map(p -> p.getLastName() + " " + p.getName().charAt(0) + "." + p.getPatronymicName().charAt(0) + ".")
                .collect(Collectors.toList());

        for (String person : withInitials) {
            System.out.println(person);
        }

        return withInitials;
    }

    @Override
    public Map<String, List<Person>> listByLastname(List<Person> listOfPeople) {

        Map<String, List<Person>> listByLastname = listOfPeople.stream()
                .collect(Collectors.groupingBy(Person::getLastName));

        for (Map.Entry<String, List<Person>> entry : listByLastname.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        return listByLastname;
    }

    @Override
    public List<Person> uniquePeople(List<Person> listOfPeople) {

        List<Person> uniquePeople = listOfPeople.stream()
                .distinct()
                .collect(Collectors.toList());

        for (Person person : uniquePeople)
            System.out.println(person);

        return uniquePeople;
    }

    @Override
    public List<Person> sortedByLastname(List<Person> listOfPeople) {

        List<Person> sortedByLastname = listOfPeople.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());

        for (Person person : sortedByLastname)
            System.out.println(person);

        return sortedByLastname;
    }

    @Override
    public List<Person> peopleByNationality(List<Person> listOfPeople, Enum<Nationality> nationality) {

        List<Person> peopleByNationality = listOfPeople.stream()
                .filter(p -> p.getNationality().name().equals(nationality.name()))
                .collect(Collectors.toList());

        System.out.println("This people are " + nationality + " : ");
        for(Person person:peopleByNationality)
        System.out.println(person);

        return peopleByNationality;
    }
}
