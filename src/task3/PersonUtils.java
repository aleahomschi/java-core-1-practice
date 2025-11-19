package task3;

import java.util.logging.Logger;

public class PersonUtils {

    private static final Logger log = Logger.getLogger(PersonUtils.class.getName());

    public static void changeIdentities(Person p1, Person p2) {

        log.info("Before identity swap:");
        log.info("p1 { Name: " + p1.getName() + ", Age: " + p1.getAge() + " }");
        log.info("p2 { Name: " + p2.getName() + ", Age: " + p2.getAge() + " }");

        String tempName = p1.getName();
        int tempAge = p1.getAge();

        p1.setName(p2.getName());
        p1.setAge(p2.getAge());

        p2.setName(tempName);
        p2.setAge(tempAge);

        log.info("After identity swap:");
        log.info("p1 { Name: " + p1.getName() + ", Age: " + p1.getAge() + " }");
        log.info("p2 { Name: " + p2.getName() + ", Age: " + p2.getAge() + " }");
    }
}
