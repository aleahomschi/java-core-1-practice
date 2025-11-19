package task1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class SortingUtility {

    private static final Logger log = Logger.getLogger(SortingUtility.class.getName());

    public static boolean isArraySorted(Scanner in) {
        int n;

        log.info("Enter the size of the array (must be 1 or greater):");
        try {
            n = in.nextInt();
        } catch (InputMismatchException e) {
            log.severe("Invalid input for array size: must be an integer.");
            throw new InputMismatchException();
        }

        if (n < 1) {
            throw new IllegalArgumentException("Size of array must be 1 or greater.");
        }

        if (n == 1) {
            log.warning("Array of size 1 is always sorted.");
        }

        int[] arr = new int[n];
        log.info("Enter " + n + " integers separated by spaces:");

        try {
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
        } catch (InputMismatchException e) {
            log.severe("Array's element should be a number");
            throw new InputMismatchException();
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                log.info("(" + arr[i - 1] + " > " + arr[i] + ")");
                return false;
            }
        }

        log.info("Array is sorted.");
        return true;
    }
}