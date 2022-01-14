package ru.yastrebov.streamtasks.decision.impl;

import org.springframework.stereotype.Service;
import ru.yastrebov.streamtasks.decision.Decision;
import ru.yastrebov.streamtasks.model.Person;
import ru.yastrebov.streamtasks.enums.Nationality;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DecisionByCyclesImpl implements Decision {

    @Override
    public List<Person> peopleOverEighteen(List<Person> listOfPeople) {

        List<Person> peopleOverEighteen = new ArrayList<>();

        for (Person person : listOfPeople) {
            if (person.getAge() > 18) {
                peopleOverEighteen.add(person);
            }
        }

        System.out.println("This people are over 18 years old:");
        for (Person person : peopleOverEighteen) {
            System.out.println(person.getId() + ". " + person.getName() + "  " + person.getPatronymicName() + "  " + person.getLastName() + " , " + person.getAge() + " , " + person.getNationality());
        }
        return (peopleOverEighteen);
    }

    @Override
    public Double averageAge(List<Person> listOfPeople) {
        Double averageAge;
        Integer tmpAverageAge = 0;
        Integer counter = 0;

        for (Person person : listOfPeople) {
            tmpAverageAge += person.getAge();
            counter++;
        }

        averageAge = (double) tmpAverageAge / counter;

        System.out.println("The average age of people is " + averageAge + " years old.");
        return averageAge;
    }

    @Override
    public Map<String, Integer> peopleOfEachNationality(List<Person> listOfPeople) {

        List<String> nationality = new ArrayList<>();

        for (Person person : listOfPeople) {
            nationality.add(person.getNationality().name());
        }

        Map<String, Integer> peopleOfEachNationality = new HashMap<>();
        for (String ntnlt : nationality) {
            Integer count = peopleOfEachNationality.get(ntnlt);
            peopleOfEachNationality.put(ntnlt, (count == null) ? 1 : count + 1);
        }

        for (Map.Entry entry : peopleOfEachNationality.entrySet()) {
            System.out.println("Nationality: " + entry.getKey() + "; Number of persons: "
                    + entry.getValue());
        }

        return peopleOfEachNationality;
    }

    @Override
    public List<String> fullNames(List<Person> listOfPeople) {

        List<String> fullNames = new ArrayList<>();
        String onePerson;

        for (Person person : listOfPeople) {
            onePerson = person.getName() + " " + person.getPatronymicName() + " " + person.getLastName();
            fullNames.add(onePerson);
        }
        for (String person : fullNames) {
            System.out.println(person);
        }
        return fullNames;
    }

    @Override
    public List<String> withInitials(List<Person> listOfPeople) {

        List<String> withInitials = new ArrayList<>();
        String onePerson;

        for (Person person : listOfPeople) {
            onePerson = person.getLastName() + " " + person.getName().charAt(0) + "." + person.getPatronymicName().charAt(0) + ".";
            withInitials.add(onePerson);
        }
        for (String person : withInitials) {
            System.out.println(person);
        }
        return withInitials;
    }

    @Override
    public Map<String, List<Person>> listByLastname(List<Person> listOfPeople) {

        List<String> lastNameList = new ArrayList<>();
        Map<String, List<Person>> listByLastname = new HashMap<>();

        for (Person person : listOfPeople) {
            if (!lastNameList.contains(person.getLastName())) {
                lastNameList.add(person.getLastName());
            }
        }
        for (String lstnm : lastNameList) {
            List<Person> namesakes = new ArrayList<>();
            for (Person person : listOfPeople) {
                if (person.getLastName().equals(lstnm)) {
                    namesakes.add(person);
                }
            }
            listByLastname.put(lstnm, namesakes);
        }
        for (Map.Entry<String, List<Person>> entry : listByLastname.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        return listByLastname;
    }

    @Override
    public List<Person> uniquePeople(List<Person> listOfPeople) {

        List<Person> uniquePeople = new ArrayList<>();
        for (Person person : listOfPeople) {
            if (!(uniquePeople.contains(person)))
                uniquePeople.add(person);
        }
        System.out.println("This is the unique people:");
        for (Person person : uniquePeople)
            System.out.println(person);

        return uniquePeople;
    }

    @Override
    public List<Person> sortedByLastname(List<Person> listOfPeople) {

        Person temp;
        List<Person> sortedByLastname = new ArrayList<>(listOfPeople);

        for (int i = 0; i < sortedByLastname.size(); i++) {
            for (int j = i + 1; j < sortedByLastname.size(); j++) {
                if (sortedByLastname.get(i).getLastName().compareTo(sortedByLastname.get(j).getLastName()) > 0) {

                    temp = sortedByLastname.get(i);
                    sortedByLastname.set(i, sortedByLastname.get(j));
                    sortedByLastname.set(j, temp);
                }
            }
        }
        for (Person person : sortedByLastname)
            System.out.println(person);

        return sortedByLastname;
    }

    @Override
    public List<Person> peopleByNationality(List<Person> listOfPeople, Enum<Nationality> nationality) {

        List<Person> peopleByNationality = new ArrayList<>();

        for (Person person : listOfPeople) {
            if ((person.getNationality().name()).equals(nationality.name())) {
                peopleByNationality.add(person);
            }
        }
        System.out.println("This people are " + nationality + " : ");
        for (Person person : peopleByNationality)
            System.out.println(person);

        return peopleByNationality;
    }
}
