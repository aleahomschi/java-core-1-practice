public class MakingChanges {
    public static void changeIdentities(Person p1, Person p2){
        System.out.println("Before:");
        System.out.println("p1:" + p1.name + " " + p1.age);
        System.out.println("p2:" + p2.name + " " + p2.age);


        String tempName = p1.name;
        int tempAge = p1.age;


        p1.name = p2.name;
        p1.age = p2.age;

        p2.name = tempName;
        p2.age = tempAge;
        System.out.println("After:");
        System.out.println("p1:" + p1.name + " " + p1.age);
        System.out.println("p2:" + p2.name + " " + p2.age);
    }
}
