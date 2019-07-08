class Main {

    public static void main(String[] args) {
        class SavePeopleListener implements PeopleManager.ISavePeopleListener {
            public void onSavePeople(int numOfPeople) {
                System.out.println(numOfPeople + " people were saved");
            }
        }

        PeopleManager.ISavePeopleListener savePeopleListener = new SavePeopleListener();
        PeopleManager.GetInstance().addSavePeopleListener(savePeopleListener);
        PeopleManager.GetInstance().savePeople();
        PeopleManager.GetInstance().removeSavePeopleListener(savePeopleListener);
    }
}
