package ru.yastrebov.streamtasks;

import ru.yastrebov.streamtasks.enums.Nationality;

import java.util.List;
import java.util.Map;

public interface Decision {
    List<Person> peopleOverEighteen(List<Person> listOfPeople);

    Double averageAge(List<Person> listOfPeople);

    Map<String, Integer> peopleOfEachNationality(List<Person> listOfPeople);

    List<String> fullNames(List<Person> listOfPeople);

    List<String> withInitials(List<Person> listOfPeople);

    Map<String, List<Person>> listByLastname(List<Person> listOfPeople);

    List<Person> uniquePeople(List<Person> listOfPeople);

    List<Person> sortedByLastname(List<Person> listOfPeople);

    List<Person> peopleByNationality(List<Person> listOfPeople, Enum<Nationality> nationality);
}
