package task4;

import java.util.Scanner;
import java.util.logging.Logger;

public class Utils {

    private static final Scanner in = new Scanner(System.in);
    private static final Logger log = Logger.getLogger(Utils.class.getName());

    public static void handleTask4() {
        log.info("Executing Task 4: Account operations.");

        User user1 = new User(123, "Mark", "Petrov");
        User user2 = new User(321, "Alex", "Petrov");

        Account[] accounts = {
                new Account(123, 10000, user1),
                new Account(199, 1000000, user2),
                new Account(456, 500, user1),
                new Account(789, 50000, user2)
        };

        AccountService service = new AccountServiceImpl(accounts);

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
