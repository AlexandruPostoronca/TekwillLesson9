public class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        // write your code here
        String nume = p1.name;
        int age = p1.age;
        p1.name = p2.name;
        p1.age = p2.age;
        p2.name = nume;
        p2.age = age;
    }

    private MakingChanges() {
    }
}