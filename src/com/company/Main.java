package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static class Person{
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

    public static void main(String[] args) {
        Random rand = new Random();
        List<String> givenNames = Arrays.asList("Rikie", "Rocker", "Olon", "Qiqi");
        List<String> givenSurname = Arrays.asList("Mask", "Nuggige", "Xu", "Li");

        List<Person> firstList = fillLists(givenNames, givenSurname, rand.nextInt(1,999999), rand.nextInt(1,10));
        List<Person> secondList = fillLists(givenNames, givenSurname, rand.nextInt(1,999999), rand.nextInt(1,10));
        List<Person> thirdList = fillLists(givenNames, givenSurname, rand.nextInt(1,999999), rand.nextInt(1,3));
        thirdList.addAll(firstList);

        System.out.println("-------- First list --------");
        firstList.forEach(person -> System.out.println(person.print()));
        System.out.println("-------- Second list --------");
        secondList.forEach(person -> System.out.println(person.print()));

        System.out.println("-------- Union ---------");
        unionPeople(firstList, secondList);
        System.out.println("-------- Union with the same People ---------");
        unionPeople(firstList, thirdList);

        System.out.println("-------- intersection ---------");
        intersectionPeople(firstList, thirdList);

        System.out.println("-------- except ---------");
        exceptPeople(firstList, secondList);
    }


    private static void exceptPeople(List<Person> firstList, List<Person> secondList) {
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

        result.forEach(person -> System.out.println(person.print()));

//        pomoci removeAll
//        Set<Person> thirdSet = new HashSet<>(secondSet);
//        thirdSet.removeAll(firstSet);
//        firstSet.removeAll(secondSet);
//        firstSet.addAll(thirdSet);
//        firstSet.forEach(person -> System.out.println(person.print()));
    }

    private static void intersectionPeople(List<Person> firstList, List<Person> secondList) {
        Set<Person> result = new HashSet<>();
        Set<Person> firstSet = new HashSet<>(firstList);
        Set<Person> secondSet = new HashSet<>(secondList);

        for (Person p : firstSet) {
            if (secondSet.contains(p)){
                result.add(p);
            }
        }
        result.forEach(person -> System.out.println(person.print()));

//        pomoci retain pro set
//        firstSet.retainAll(secondSet);
//        firstSet.forEach(person -> System.out.println(person.print()));
    }

    private static void unionPeople(List<Person> firstList, List<Person> secondList) {
        Set<Person> result = new HashSet<>();

        result.addAll(firstList);
        result.addAll(secondList);
        result.forEach(person -> System.out.println(person.print()));

//        hezci zpusob reseni?
//        Stream.concat(firstList.stream(), secondList.stream()).collect(Collectors.toSet())
//                .forEach(person -> System.out.println(person.print()));
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
