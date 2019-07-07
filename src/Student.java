public class Student extends Person {
    private String major;

    public Student(String name, String lastName, String major) {
        super(name, lastName);
        this.major = major;
    }

    @Override
    public String getFullName() {
        return super.getFullName() + ", " + major;
    }

    @Override
    public String toString() {
        return "Student:\t" + getFullName();
    }
}
