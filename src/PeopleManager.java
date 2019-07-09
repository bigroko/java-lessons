import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class PeopleManager implements Runnable {
    private static volatile PeopleManager peopleManager = null;
    private final Set<ISavePeopleListener> listeners = new CopyOnWriteArraySet<>();

    //Private constructor to implement singleton
    private PeopleManager() {
    }

    //Singleton
    static PeopleManager getInstance() {
        if (peopleManager == null) {
            synchronized (PeopleManager.class) {
                if (peopleManager == null) {
                    peopleManager = new PeopleManager();
                }
            }
        }
        return peopleManager;
    }

    //Thread start point
    public void run() {
        System.out.println("Entering PeopleManager.run()...");

        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person());
        people.add(new Person("Michael", "Scott"));
        people.add(new Student("Pam", "Beasley", "\"International Communication\""));
        people.add(new Student("Bob", "Vance", "\"Marketing\""));

        notifySavePeopleListeners(writeToFile(people));

        System.out.println("Exiting PeopleManager.run()...");
    }

    //Add observers
    void addSavePeopleListener(final ISavePeopleListener listener) {
        System.out.println("Adding listener...");
        listeners.add(listener);
    }

    //Remove observers
    void removeSavePeopleListener(final ISavePeopleListener listener) {
        System.out.println("Removing listener...");
        listeners.remove(listener);
    }

    //Raise an event for all the observers
    private void notifySavePeopleListeners(int numOfPeople) {
        for (ISavePeopleListener listener : listeners) {
            System.out.println("Generating event...");
            listener.onSavePeople(numOfPeople);
        }
    }

    //Work with file
    private int writeToFile(ArrayList<Person> people) {
        int i = 0;

        try {
            FileWriter fw = new FileWriter(Constants.PERSONS_FILE_NAME, true);
            System.out.println("Starting writing to file...");
            fw.write("---\n");
            for (Person person : people) {
                System.out.println(person);
                fw.write(person + "\n");
                i++;
            }
            fw.close();
            System.out.println("Ending writing to file...");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    //Interface to implement an observer
    interface ISavePeopleListener {
        void onSavePeople(final int numOfPeople);
    }
}
