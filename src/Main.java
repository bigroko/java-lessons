import java.io.FileWriter;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person());
        people.add(new Person("Michael", "Scott"));
        people.add(new Student("Pam", "Beasley", "\"International Communication\""));
        people.add(new Student("Bob", "Vance", "\"Marketing\""));

        writeToFile(people);
    }

    private static void writeToFile(ArrayList<Person> people) {
        try {
            FileWriter fw = new FileWriter("persons.txt", true);
            fw.write("---\n");
            for (Person person : people) {
                System.out.println(person);
                fw.write(person + "\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
