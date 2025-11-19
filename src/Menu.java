import task1.SortingUtility;
import task2.ReversingUtility;
import task3.PersonUtils;
import task3.Person;
import task4.Account;
import task4.AccountService;
import task4.AccountServiceMpl;
import task4.User;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    private static final Scanner in = new Scanner(System.in);
    private static final Logger log = Logger.getLogger(Menu.class.getName());

    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new loggerFormat.ColorFormatter());
        handler.setLevel(Level.ALL);

        Logger root = Logger.getLogger("");

        for (var h : root.getHandlers()) {
            root.removeHandler(h);
        }

        root.addHandler(handler);
        root.setUseParentHandlers(false);
    }


    private static final String MENU_OPTIONS =
            "--- Main Menu --- \n" +
                    "1 - Check if array is ascending\n" +
                    "2 - Reverse a string\n" +
                    "3 - Switch identities of two persons\n" +
                    "4 - User account operations\n" +
                    "0 - Exit\n" +
                    "Please enter your choice (0-4):";

    private static final String MENU_STRING_OPTIONS =
            "--- String Menu --- \n" +
                    "1 - Reverse using String\n" +
                    "2 - Reverse using StringBuilder\n" +
                    "3 - Reverse using StringBuffer\n" +
                    "4 - Reverse using Stack\n" +
                    "5 - Reverse using CharArray\n" +
                    "0 - Exit\n" +
                    "Please enter your choice (0-5):";

    public static void run() {
        int choice = -1;

        do {
            log.info(MENU_OPTIONS);

            try {
                if (in.hasNextInt()) {
                    choice = in.nextInt();
                    in.nextLine();
                } else {
                    log.warning("Invalid input (not an integer).");
                    in.next();
                    continue;
                }

                log.info("User selected option: " + choice);

                switch (choice) {
                    case 1 -> {
                        boolean result = SortingUtility.isArraySorted(in);
                        log.info("Is array sorted ascending? " + result);
                    }
                    case 2 -> {
                        log.info(MENU_STRING_OPTIONS);
                        int choiceString = in.nextInt();

                        switch (choiceString) {
                            case 1 -> ReversingUtility.reverseUsingString(in);
                            case 2 -> ReversingUtility.reverseUsingStringBuilder(in);
                            case 3 -> ReversingUtility.reverseUsingStringBuffer(in);
                            case 4 -> ReversingUtility.reverseUsingStack(in);
                            case 5 -> ReversingUtility.reverseUsingCharArray(in);
                            case 0 -> log.info("Exiting operation");
                            default -> log.warning("Unknown option selected: " + choiceString);
                        }

                    }
                    case 3 -> handleTask3();
                    case 4 -> handleTask4();
                    case 0 -> log.info("Exiting application");
                    default -> log.warning("Unknown option selected: " + choice);
                }

            } catch (Exception e) {
                choice = -1;
            }

        } while (choice != 0);

        log.info("Good Bye.");
    }

    private static void handleTask3() {
        log.info("Executing Task 3: Identity Swap.");

        log.info("--- Setup Person 1 ---");
        log.info("Enter person 1's name:");
        String person1Name = in.nextLine();

        log.info("Enter person 1's age (integer):");
        int person1Age = in.nextInt();
        in.nextLine();
        Person p1 = new Person(person1Name, person1Age);

        log.info("--- Setup Person 2 ---");
        log.info("Enter person 2's name:");
        String person2Name = in.nextLine();

        log.info("Enter person 2's age (integer):");
        int person2Age = in.nextInt();
        in.nextLine();
        Person p2 = new Person(person2Name, person2Age);

        log.info("Changing identities...");
        PersonUtils.changeIdentities(p1, p2);

        log.info("Identities successfully changed.");


    }

    private static void handleTask4() {
        log.info("Executing Task 4: Account operations.");

        User user1 = new User(123, "Mark", "Petrov");
        User user2 = new User(321, "Alex", "Petrov");

        Account[] accounts = {
                new Account(123, 10000, user1),
                new Account(199, 1000000, user2),
                new Account(456, 500, user1),
                new Account(789, 50000, user2)
        };

        AccountService service = new AccountServiceMpl(accounts);

        log.info("--- All Accounts ---");
        service.show();

        log.info("Enter balance threshold (integer):");
        int balance = in.nextInt();
        in.nextLine();

        long count = service.countAccountsWithBalanceGreaterThan(balance);
        log.info("Result: " + count + " accounts found.");

        log.info("Enter owner ID (integer):");
        int id = in.nextInt();
        in.nextLine();

        Account found = service.findAccountByOwnerId(id);
        log.info("Search Result: " + (found != null ? found : "Not found."));
    }
}