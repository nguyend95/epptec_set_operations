package com.company;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class Person {
    public long nation_id;
    public String name;
    public String surname;

    public String print(){
        return "name: " + name +
                "\nsurname: " + surname +
                "\nnation id: " + nation_id +
                "\n------------- - ------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return nation_id == person.nation_id && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nation_id, name, surname);
    }
}
