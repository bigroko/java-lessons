class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        PeopleManager peopleManager = new PeopleManager("persons.txt");
        System.out.println(peopleManager.savePeople() + " people were saved");
    }
}
