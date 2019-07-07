public class Person {
    private String name;
    private String lastName;

    public Person() {
        this.name = "John";
        this.lastName = "Smith";
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getFullName() {
        return (name + " " + lastName);
    }

    @Override
    public String toString() {
        return "Person:\t\t" + getFullName();
    }
}
