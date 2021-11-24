package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetOperators {
    private Printer printer;

    public SetOperators(Printer printer) {
        this.printer = printer;
    }

    public void exceptPeople(List<Person> firstList, List<Person> secondList) {
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

    public void intersectionPeople(List<Person> firstList, List<Person> secondList) {
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

    public void unionPeople(List<Person> firstList, List<Person> secondList) {
        Set<Person> result = new HashSet<>();

        result.addAll(firstList);
        result.addAll(secondList);
        printer.printData(result);

//        hezci zpusob reseni?
//        printData(Stream.concat(firstList.stream(), secondList.stream()).collect(Collectors.toSet()));
    }
}
