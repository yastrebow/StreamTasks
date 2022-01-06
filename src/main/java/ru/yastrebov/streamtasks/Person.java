package ru.yastrebov.streamtasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.yastrebov.streamtasks.enums.Nationality;

@Data
@AllArgsConstructor
public class Person {
    @EqualsAndHashCode.Exclude
    private final Integer id;
    private final String name;
    private final String lastName;
    private final String patronymicName;
    private final Integer age;
    private final Nationality nationality;


}
