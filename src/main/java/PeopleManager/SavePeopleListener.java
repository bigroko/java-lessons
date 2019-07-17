package main.java.PeopleManager;

class SavePeopleListener implements PeopleManager.PeopleListener {
    public void onSavePeople(final int numOfPeople) {
        System.out.println("Catching event: " + numOfPeople + " people were saved");
    }
}
