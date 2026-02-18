package task3;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PersonUtils {

    private static final Scanner in = new Scanner(System.in);
    private static final Logger log = Logger.getLogger(PersonUtils.class.getName());

    public static void changeIdentities(Person p1, Person p2) {
        if (p1 == null || p2 == null) {
            log.severe("Swap failed: One or both Person instances are null.");
            throw new IllegalArgumentException("Cannot perform swap on null Person instances.");
        }

        boolean sameName = (p1.getName() == null && p2.getName() == null) || (p1.getName() != null && p1.getName().equals(p2.getName()));

        if (sameName && p1.getAge() == p2.getAge()) {
            log.warning("Swap skipped: Persons already have identical identity fields.");
            throw new IllegalArgumentException("Persons cannot have identical identity fields (Name and Age are the same).");
        }

        log.info("Before identity swap:");
        log.info(String.format("p1 { Name: %s, Age: %d }", p1.getName(), p1.getAge()));
        log.info(String.format("p2 { Name: %s, Age: %d }", p2.getName(), p2.getAge()));

        String tempName = p1.getName();
        int tempAge = p1.getAge();

        p1.setName(p2.getName());
        p1.setAge(p2.getAge());

        p2.setName(tempName);
        p2.setAge(tempAge);

        log.info("After identity swap:");
        log.info(String.format("p1 { Name: %s, Age: %d }", p1.getName(), p1.getAge()));
        log.info(String.format("p2 { Name: %s, Age: %d }", p2.getName(), p2.getAge()));
    }

    public static void handleTask3() {
        log.info("Executing Task 3: Identity Swap.");

        try {
            log.info("--- Setup Person 1 ---");
            log.info("Enter person 1's name:");
            String person1Name = in.nextLine();

            log.info("Enter person 1's age (integer):");
            int person1Age = Integer.parseInt(in.nextLine());
            Person p1 = new Person(person1Name, person1Age);

            log.info("--- Setup Person 2 ---");
            log.info("Enter person 2's name:");
            String person2Name = in.nextLine();

            log.info("Enter person 2's age (integer):");
            int person2Age = Integer.parseInt(in.nextLine());
            Person p2 = new Person(person2Name, person2Age);

            log.info("Attempting to change identities...");

            changeIdentities(p1, p2);

            log.info("Identities successfully changed.");

        } catch (NumberFormatException e) {
            log.log(Level.SEVERE, "Invalid input for age. Please enter a valid integer.", e);
        } catch (IllegalArgumentException e) {
            log.log(Level.WARNING, "Operation prevented: " + e.getMessage());
        } catch (Exception e) {
            log.log(Level.SEVERE, "An unexpected error occurred.", e);
        }
    }
}