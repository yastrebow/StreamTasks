package ru.yastrebov.streamtasks.decision.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.yastrebov.streamtasks.model.Person;
import ru.yastrebov.streamtasks.enums.Nationality;
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
        List<String> fullNamesTest = List.of("Василий Иванович Чапаев", "Василий Иванович Чапаев", "Виктор Ипполитович Чапаев",
                "Сергей Владиславович Иванов", "Семен Аронович Рабинович", "Арон Моисеевич Рабинович", "Василий Петрович Иванов",
                "Василиса Сергеевна Иванова", "Мария Петровна Бубка", "Циля Соломоновна Лифшиц", "Виктория Серафимовна Иванова",
                "Цецилия Федоровна Погорелова", "Василий Петрович Иванов", "Василиса Сергеевна Иванова");

        assertEquals(fullNames, fullNamesTest);
    }

    @Test
    void withInitialsTest() {
        List<String> withInitials = decisionByCycles.withInitials(testListOfPeople);
        List<String> withInitialsTest = List.of("Чапаев В.И.", "Чапаев В.И.", "Чапаев В.И.", "Иванов С.В.", "Рабинович С.А.", "Рабинович А.М.",
                "Иванов В.П.", "Иванова В.С.", "Бубка М.П.", "Лифшиц Ц.С.", "Иванова В.С.", "Погорелова Ц.Ф.", "Иванов В.П.", "Иванова В.С.");

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
        List<Person> uniquePeopleTest = List.of(p1, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);

        assertEquals(uniquePeople, uniquePeopleTest);
    }

    @Test
    void sortedByLastnameTest() {
        List<Person> sortedByLastname = decisionByCycles.sortedByLastname(testListOfPeople);
        List<Person> sortedByLastnameTest = List.of(p9, p7, p4, p13, p11, p8, p14, p10, p12, p5, p6, p3, p1, p2);

        assertEquals(sortedByLastname, sortedByLastnameTest);
    }

    @Test
    void peopleByNationalityTest() {
        List<Person> peopleByNationality = decisionByCycles.peopleByNationality(testListOfPeople, nationality);
        List<Person> peopleByNationalityText = List.of(p4, p6, p8, p11, p12, p14);

        assertEquals(peopleByNationality, peopleByNationalityText);
    }
}