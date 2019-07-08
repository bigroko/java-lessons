class Main {

    public static void main(String[] args) {
        class SavePeopleListener implements PeopleManager.ISavePeopleListener {
            public void onSavePeople(int numOfPeople) {
                System.out.println(numOfPeople + " people were saved");
            }
        }

        PeopleManager peopleManager = new PeopleManager();
        PeopleManager.ISavePeopleListener savePeopleListener = new SavePeopleListener();
        peopleManager.setSavePeopleListener(savePeopleListener);
        peopleManager.savePeople();
    }
}
