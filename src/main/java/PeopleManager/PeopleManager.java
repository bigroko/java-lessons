package main.java.PeopleManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class PeopleManager implements Runnable {
    private static volatile PeopleManager peopleManager = null;
    private final Set<PeopleListener> listeners = new CopyOnWriteArraySet<>();

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
        Person[] people = new Person[]{
                new Person(),
                new Person("Michael", "Scott"),
                new Student("Pam", "Beasley", "\"International Communication\""),
                new Student("Bob", "Vance", "\"Marketing\"")
        };
        notifySavePeopleListeners(writeToFile(people));
        System.out.println("Exiting PeopleManager.run()...");
    }

    //Add observers
    void addSavePeopleListener(final PeopleListener listener) {
        System.out.println("Adding listener...");
        listeners.add(listener);
    }

    //Remove observers
    void removeSavePeopleListener(final PeopleListener listener) {
        System.out.println("Removing listener...");
        listeners.remove(listener);
    }

    //Raise an event for all the observers
    private void notifySavePeopleListeners(int numOfPeople) {
        for (PeopleListener listener : listeners) {
            System.out.println("Generating SavePeople event...");
            listener.onSavePeople(numOfPeople);
        }
    }

    //Work with file
    private int writeToFile(Person[] people) {
        int i = 0;

        try (FileWriter fw = new FileWriter(Constants.PERSONS_FILE_NAME, true)) {
            System.out.println("Starting writing to file...");
            fw.write("---\n");
            for (Person person : people) {
                System.out.println(person);
                fw.write(person + "\n");
                i++;
            }
            System.out.println("Ending writing to file...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return i;
    }

    //Interface to implement an observer
    interface PeopleListener {
        void onSavePeople(final int numOfPeople);
    }
}
