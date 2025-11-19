package task2;

import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

public class ReversingUtility {

    private static final Logger log = Logger.getLogger(ReversingUtility.class.getName());

    public static void reverseUsingString(Scanner in) {
        log.info("Enter your string:");
        String str = in.nextLine();
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        log.info(str + " <- Reverse -> " + reversed);

    }

    public static void reverseUsingStringBuilder(Scanner in) {
        log.info("Enter your string:");
        String str = in.nextLine();

        StringBuilder reversed = new StringBuilder(str).reverse();

        log.info(str + " <- Reverse -> " + reversed);
    }

    public static void reverseUsingStringBuffer(Scanner in) {
        log.info("Enter your string:");
        String str = in.nextLine();

        StringBuffer reversed = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        log.info(str + " <- Reverse -> " + reversed);
    }

    public static void reverseUsingStack(Scanner in) {
        log.info("Enter your string:");
        String str = in.nextLine();

        char[] reversed = new char[str.length()];
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        int i = 0;
        while (!stack.isEmpty()) {
            reversed[i++] = stack.pop();
        }

        String result = new String(reversed);
        log.info(str + " <- Reverse -> " + result);

    }

    public static void reverseUsingCharArray(Scanner in) {
        log.info("Enter your string:");
        String str = in.nextLine();

        char[] charArray = str.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        String result = new String(charArray);
        log.info(str + "<- Reverse -> " + result);
    }
}



