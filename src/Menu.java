import task1.SortingUtility;
import task2.ReversingUtility;
import task4.*;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static task3.PersonUtils.handleTask3;
import static task4.Utils.handleTask4;

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

            } catch (java.util.InputMismatchException e) {
                log.severe("User Input Error: Expected a numeric value but received invalid characters.");
                choice = -1;
                in.nextLine();
            } catch (Exception e) {
                log.severe("Unexpected system error occurred during operation " + choice + " " + e.getMessage());
                choice = -1;
            }

        } while (choice != 0);

        log.info("Good Bye.");
    }

}