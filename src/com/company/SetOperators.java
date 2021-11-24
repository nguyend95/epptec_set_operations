package com.company;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetOperators {
    private final Printer printer;

    public SetOperators(Printer printer) {
        this.printer = printer;
    }

    public void exceptPeople(Collection<Person> firstList, Collection<Person> secondList) {
        Set<Person> result = new HashSet<>();
        Set<Person> firstSet = new HashSet<>(firstList);
        Set<Person> secondSet = new HashSet<>(secondList);

        for (Person p : firstSet) {
            if (!secondSet.contains(p)) {
                result.add(p);
            }
        }

        for (Person p : secondSet) {
            if (!firstSet.contains(p)) {
                result.add(p);
            }
        }

        printer.printData(result);

//        pomoci removeAll
//        Set<Person> thirdSet = new HashSet<>(secondSet);
//        thirdSet.removeAll(firstSet);
//        firstSet.removeAll(secondSet);
//        firstSet.addAll(thirdSet);
//        printData(firstSet);
    }

    public void intersectionPeople(Collection<Person> firstList, Collection<Person> secondList) {
        Set<Person> result = new HashSet<>();
        Set<Person> firstSet = new HashSet<>(firstList);
        Set<Person> secondSet = new HashSet<>(secondList);

        for (Person p : firstSet) {
            if (secondSet.contains(p)){
                result.add(p);
            }
        }
        printer.printData(result);

//        pomoci retain pro set
//        firstSet.retainAll(secondSet);
//        printData(firstSet);
    }

    public void unionPeople(Collection<Person> firstList, Collection<Person> secondList) {
        Set<Person> result = new HashSet<>();

        result.addAll(firstList);
        result.addAll(secondList);
        printer.printData(result);

//        hezci zpusob reseni?
//        printData(Stream.concat(firstList.stream(), secondList.stream()).collect(Collectors.toSet()));
    }
}
