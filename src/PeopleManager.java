import java.io.FileWriter;
import java.util.ArrayList;

class PeopleManager {
    private ArrayList<ISavePeopleListener> listeners;

    interface ISavePeopleListener {
        void onSavePeople(int numOfPeople);
    }

    void setSavePeopleListener(ISavePeopleListener listener) {
        if (listeners == null) {
            listeners = new ArrayList<>();
        }
        listeners.add(listener);
    }

    void savePeople() {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person());
        people.add(new Person("Michael", "Scott"));
        people.add(new Student("Pam", "Beasley", "\"International Communication\""));
        people.add(new Student("Bob", "Vance", "\"Marketing\""));

        notifySavePeopleListeners(writeToFile(people));
    }

    private void notifySavePeopleListeners (int numOfPeople) {
        if (listeners != null) {
            for(ISavePeopleListener listener : listeners) {
                listener.onSavePeople(numOfPeople);
            }
        }
    }

    private int writeToFile(ArrayList<Person> people) {
        int i = 0;

        try {
            FileWriter fw = new FileWriter(Constants.PERSONS_FILE_NAME, true);
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
