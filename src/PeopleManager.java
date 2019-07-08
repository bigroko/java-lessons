import java.io.FileWriter;
import java.util.ArrayList;

class PeopleManager {
    private static PeopleManager peopleManager = null;
    private ArrayList<ISavePeopleListener> listeners;

    private PeopleManager() {
        //Private constructor to avoid create an instance outside this class
    }

    //Singleton
    static PeopleManager GetInstance() {
        if (peopleManager == null) {
            peopleManager = new PeopleManager();
        }
        return peopleManager;
    }

    //Add observers
    void addSavePeopleListener(ISavePeopleListener listener) {
        if (listeners == null) {
            listeners = new ArrayList<>();
        }
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    //Remove observers
    void removeSavePeopleListener(ISavePeopleListener listener) {
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    //Main procedure
    void savePeople() {
        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person());
        people.add(new Person("Michael", "Scott"));
        people.add(new Student("Pam", "Beasley", "\"International Communication\""));
        people.add(new Student("Bob", "Vance", "\"Marketing\""));

        notifySavePeopleListeners(writeToFile(people));
    }

    //Raise an event for all the observers
    private void notifySavePeopleListeners(int numOfPeople) {
        if (listeners != null) {
            for (ISavePeopleListener listener : listeners) {
                listener.onSavePeople(numOfPeople);
            }
        }
    }

    //Work with file
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

    //Interface to implement an observer
    interface ISavePeopleListener {
        void onSavePeople(int numOfPeople);
    }
}
