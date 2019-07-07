import java.io.FileWriter;
import java.util.ArrayList;

class PeopleManager {
    private String fileName;

    PeopleManager(String fileName) {
        this.fileName = fileName;
    }

    int savePeople() {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person());
        people.add(new Person("Michael", "Scott"));
        people.add(new Student("Pam", "Beasley", "\"International Communication\""));
        people.add(new Student("Bob", "Vance", "\"Marketing\""));

        return writeToFile(fileName, people);
    }

    private int writeToFile(String fileName, ArrayList<Person> people) {
        int i = 0;

        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write("---\n");
            for (Person person : people) {
                System.out.println(person);
                fw.write(person + "\n");
                i++;
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
}
