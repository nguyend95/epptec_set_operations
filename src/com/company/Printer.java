package com.company;

public class Printer {
    public void printData(Iterable<Person> data) {
        data.forEach(person -> System.out.println(person.print()));
    }

    public void printSeparator(String text) {
        System.out.println("-------- " + text + "------");
    }
}
