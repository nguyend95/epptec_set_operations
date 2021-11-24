package com.company;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class Person {
    private String personalId;
    private String name;
    private String surname;

    @Override
    public String toString(){
        return "name: " + name +
                "\nsurname: " + surname +
                "\nnation id: " + personalId +
                "\n------------- - ------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personalId, person.personalId) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalId, name, surname);
    }
}
