package ru.yastrebov.streamtasks.decision.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.yastrebov.streamtasks.model.Person;
import ru.yastrebov.streamtasks.decision.impl.DecisionByCyclesImpl;
import ru.yastrebov.streamtasks.enums.Nationality;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static ru.yastrebov.streamtasks.enums.Nationality.JEW;
import static ru.yastrebov.streamtasks.enums.Nationality.RUSSIAN;
import static ru.yastrebov.streamtasks.enums.Nationality.UKRAINIAN;

@RunWith(MockitoJUnitRunner.class)
class DecisionByCyclesImplTest {
    private final Enum<Nationality> nationality = RUSSIAN;
    private final DecisionByCyclesImpl decisionByCycles = new DecisionByCyclesImpl();

    private final Person p1 = new Person(1, "Василий", "Чапаев", "Иванович", 45, Nationality.UKRAINIAN);
    private final Person p2 = new Person(2, "Василий", "Чапаев", "Иванович", 45, Nationality.UKRAINIAN);
    private final Person p3 = new Person(3, "Виктор", "Чапаев", "Ипполитович", 37, Nationality.JEW);
    private final Person p4 = new Person(4, "Сергей", "Иванов", "Владиславович", 37, Nationality.RUSSIAN);
    private final Person p5 = new Person(5, "Семен", "Рабинович", "Аронович", 56, Nationality.JEW);
    private final Person p6 = new Person(6, "Арон", "Рабинович", "Моисеевич", 16, Nationality.RUSSIAN);
    private final Person p7 = new Person(7, "Василий", "Иванов", "Петрович", 37, Nationality.JEW);
    private final Person p8 = new Person(8, "Василиса", "Иванова", "Сергеевна", 27, Nationality.RUSSIAN);
    private final Person p9 = new Person(9, "Мария", "Бубка", "Петровна", 17, Nationality.UKRAINIAN);
    private final Person p10 = new Person(10, "Циля", "Лифшиц", "Соломоновна", 67, Nationality.JEW);
    private final Person p11 = new Person(11, "Виктория", "Иванова", "Серафимовна", 47, Nationality.RUSSIAN);
    private final Person p12 = new Person(12, "Цецилия", "Погорелова", "Федоровна", 5, Nationality.RUSSIAN);
    private final Person p13 = new Person(13, "Василий", "Иванов", "Петрович", 37, Nationality.JEW);
    private final Person p14 = new Person(14, "Василиса", "Иванова", "Сергеевна", 27, Nationality.RUSSIAN);

    private final List<Person> testListOfPeople = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);

    @Test
    void peopleOverEighteenTest() {
        List<Person> peopleOverEighteenList = List.of(p1, p2, p3, p4, p5, p7, p8, p10, p11, p13, p14);

        List<Person> people = decisionByCycles.peopleOverEighteen(testListOfPeople);

        assertEquals(people, peopleOverEighteenList);
    }

    @Test
    void averageAgeTest() {
        double averageAgeTest = (double) (45 + 45 + 37 + 37 + 56 + 16 + 37 + 27 + 17 + 67 + 47 + 5 + 37 + 27) / 14;

        double averageAge = decisionByCycles.averageAge(testListOfPeople);

        assertEquals(averageAge, averageAgeTest);
    }

    @Test
    void peopleOfEachNationalityTest() {

        Map<String, Integer> peopleOfEachNationality = decisionByCycles.peopleOfEachNationality(testListOfPeople);

        Map<String, Integer> peopleOfEachNationalityTest = new HashMap<>();
        peopleOfEachNationalityTest.put(RUSSIAN.toString(), 6);
        peopleOfEachNationalityTest.put(JEW.toString(), 5);
        peopleOfEachNationalityTest.put(UKRAINIAN.toString(), 3);

        assertEquals(peopleOfEachNationality, peopleOfEachNationalityTest);
    }

    @Test
    void fullNamesTest() {

        List<String> fullNames = decisionByCycles.fullNames(testListOfPeople);
        List<String> fullNamesTest = new ArrayList<>();

        fullNamesTest.add("Василий Иванович Чапаев");
        fullNamesTest.add("Василий Иванович Чапаев");
        fullNamesTest.add("Виктор Ипполитович Чапаев");
        fullNamesTest.add("Сергей Владиславович Иванов");
        fullNamesTest.add("Семен Аронович Рабинович");
        fullNamesTest.add("Арон Моисеевич Рабинович");
        fullNamesTest.add("Василий Петрович Иванов");
        fullNamesTest.add("Василиса Сергеевна Иванова");
        fullNamesTest.add("Мария Петровна Бубка");
        fullNamesTest.add("Циля Соломоновна Лифшиц");
        fullNamesTest.add("Виктория Серафимовна Иванова");
        fullNamesTest.add("Цецилия Федоровна Погорелова");
        fullNamesTest.add("Василий Петрович Иванов");
        fullNamesTest.add("Василиса Сергеевна Иванова");

        assertEquals(fullNames, fullNamesTest);
    }

    @Test
    void withInitialsTest() {
        List<String> withInitials = decisionByCycles.withInitials(testListOfPeople);

        List<String> withInitialsTest = new ArrayList<>();
        withInitialsTest.add("Чапаев В.И.");
        withInitialsTest.add("Чапаев В.И.");
        withInitialsTest.add("Чапаев В.И.");
        withInitialsTest.add("Иванов С.В.");
        withInitialsTest.add("Рабинович С.А.");
        withInitialsTest.add("Рабинович А.М.");
        withInitialsTest.add("Иванов В.П.");
        withInitialsTest.add("Иванова В.С.");
        withInitialsTest.add("Бубка М.П.");
        withInitialsTest.add("Лифшиц Ц.С.");
        withInitialsTest.add("Иванова В.С.");
        withInitialsTest.add("Погорелова Ц.Ф.");
        withInitialsTest.add("Иванов В.П.");
        withInitialsTest.add("Иванова В.С.");

        assertEquals(withInitials, withInitialsTest);
    }

    @Test
    void listByLastnameTest() {
        Map<String, List<Person>> listByLastname = decisionByCycles.listByLastname(testListOfPeople);
        Map<String, List<Person>> listByLastnameTest = new HashMap<>();

        List<Person> listChapayev = List.of(p1, p2, p3);
        List<Person> listIvanov = List.of(p4, p7, p13);
        List<Person> listIvanova = List.of(p8, p11, p14);
        List<Person> listRabinovich = List.of(p5, p6);
        List<Person> listBubka = List.of(p9);
        List<Person> listLifshits = List.of(p10);
        List<Person> listPogorelova = List.of(p12);

        listByLastnameTest.put("Иванова", listIvanova);
        listByLastnameTest.put("Рабинович", listRabinovich);
        listByLastnameTest.put("Погорелова", listPogorelova);
        listByLastnameTest.put("Иванов", listIvanov);
        listByLastnameTest.put("Лифшиц", listLifshits);
        listByLastnameTest.put("Чапаев", listChapayev);
        listByLastnameTest.put("Бубка", listBubka);

        assertEquals(listByLastname, listByLastnameTest);
    }

    @Test
    void uniquePeopleTest() {
        List<Person> uniquePeople = decisionByCycles.uniquePeople(testListOfPeople);
        List<Person> uniquePeopleTest = new ArrayList<>();

        uniquePeopleTest.add(p1);
        uniquePeopleTest.add(p3);
        uniquePeopleTest.add(p4);
        uniquePeopleTest.add(p5);
        uniquePeopleTest.add(p6);
        uniquePeopleTest.add(p7);
        uniquePeopleTest.add(p8);
        uniquePeopleTest.add(p9);
        uniquePeopleTest.add(p10);
        uniquePeopleTest.add(p11);
        uniquePeopleTest.add(p12);

        assertEquals(uniquePeople, uniquePeopleTest);
    }

    @Test
    void sortedByLastnameTest() {
        List<Person> sortedByLastname = decisionByCycles.sortedByLastname(testListOfPeople);
        List<Person> sortedByLastnameTest = new ArrayList<>();

        sortedByLastnameTest.add(p9);
        sortedByLastnameTest.add(p7);
        sortedByLastnameTest.add(p4);
        sortedByLastnameTest.add(p13);
        sortedByLastnameTest.add(p11);
        sortedByLastnameTest.add(p8);
        sortedByLastnameTest.add(p14);
        sortedByLastnameTest.add(p10);
        sortedByLastnameTest.add(p12);
        sortedByLastnameTest.add(p5);
        sortedByLastnameTest.add(p6);
        sortedByLastnameTest.add(p3);
        sortedByLastnameTest.add(p1);
        sortedByLastnameTest.add(p2);

        assertEquals(sortedByLastname, sortedByLastnameTest);
    }

    @Test
    void peopleByNationalityTest() {
        List<Person> peopleByNationality = decisionByCycles.peopleByNationality(testListOfPeople, nationality);
        List<Person> peopleByNationalityText = new ArrayList<>();

        peopleByNationalityText.add(p4);
        peopleByNationalityText.add(p6);
        peopleByNationalityText.add(p8);
        peopleByNationalityText.add(p11);
        peopleByNationalityText.add(p12);
        peopleByNationalityText.add(p14);

        assertEquals(peopleByNationality, peopleByNationalityText);
    }
}