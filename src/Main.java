class Main {
    public static void main(String[] args) {
        System.out.println("Entering main...");

        try {
            SavePeopleListener listener = new SavePeopleListener();
            PeopleManager.getInstance().addSavePeopleListener(listener);
            Thread thread = new Thread(PeopleManager.getInstance());
            thread.start();
            thread.join();
            PeopleManager.getInstance().removeSavePeopleListener(listener);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Exiting main...");
    }
}

class SavePeopleListener implements PeopleManager.ISavePeopleListener {
    public void onSavePeople(final int numOfPeople) {
        System.out.println("Catching event: " + numOfPeople + " people were saved");
    }
}
