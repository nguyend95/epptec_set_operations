package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        SetOperators setOperators = new SetOperators(printer);
        Random rand = new Random();
        List<String> givenNames = Arrays.asList("Rikie", "Rocker", "Olon", "Qiqi");
        List<String> givenSurname = Arrays.asList("Mask", "Nuggige", "Xu", "Li");

        List<Person> firstList = fillLists(givenNames, givenSurname, rand.nextInt(1,999999), rand.nextInt(1,10));
        List<Person> secondList = fillLists(givenNames, givenSurname, rand.nextInt(1,999999), rand.nextInt(1,10));
        List<Person> thirdList = fillLists(givenNames, givenSurname, rand.nextInt(1,999999), rand.nextInt(1,3));
        thirdList.addAll(firstList);

        printer.printSeparator("First list");
        printer.printData(firstList);
        printer.printSeparator("Second list");
        printer.printData(secondList);

        printer.printSeparator("Union");
        setOperators.unionPeople(firstList, secondList);
        printer.printSeparator("Union with the same People");
        setOperators.unionPeople(firstList, thirdList);

        printer.printSeparator("intersection");
        setOperators.intersectionPeople(firstList, thirdList);

        printer.printSeparator("except");
        setOperators.exceptPeople(firstList, secondList);
    }

    private static List<Person> fillLists(List<String> names, List<String> surnames,
                                          int idRange, int personToCreate) {
        List<Person> result = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < personToCreate; i++) {
            Person person = new Person();
            int randomNameIndex = rand.nextInt(names.size());
            int randomSurnameIndex = rand.nextInt(surnames.size());

            person.name = names.get(randomNameIndex);
            person.surname = surnames.get(randomSurnameIndex);
            person.nation_id = rand.nextInt(idRange);

            result.add(person);
        }

        return result;
    }
}
