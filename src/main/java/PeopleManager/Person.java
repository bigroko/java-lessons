package main.java.PeopleManager;

class Person {
    private final String name;
    private final String lastName;

    Person() {
        this.name = "John";
        this.lastName = "Smith";
    }

    Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    String getFullName() {
        return (name + " " + lastName);
    }

    @Override
    public String toString() {
        return "Person:\t\t" + getFullName();
    }
}
