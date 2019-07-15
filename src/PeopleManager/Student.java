package PeopleManager;

class Student extends Person {
    private final String major;

    Student(String name, String lastName, String major) {
        super(name, lastName);
        this.major = major;
    }

    @Override
    String getFullName() {
        return super.getFullName() + ", " + major;
    }

    @Override
    public String toString() {
        return "Student:\t" + getFullName();
    }
}
