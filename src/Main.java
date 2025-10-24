import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;

        do{

            System.out.println("1 - is array ascending, 2 - reverse string, 3 - switch identities of persons, 4 - user machinations");
            n = in.nextInt();
            switch (n){
                case 1: {SortedArray.arrayAscending(); break;}
                case 2: {ReverseString.reverseString(); break;}
                case 3: {
                    System.out.println("Enter person's name:");
                    String PersonName = in.next();
                    System.out.println("Enter person's age:");
                    int PersonAge = in.nextInt();

                    Person p1 = new Person(PersonName, PersonAge);

                    System.out.println("Enter person's name:");
                    PersonName = in.next();
                    System.out.println("Enter person's age:");
                    PersonAge = in.nextInt();

                    Person p2 = new Person(PersonName, PersonAge);

                    MakingChanges.changeIdentities(p1,p2);
                    break;
                }
                case 4: {
                    User user1 = new User(123, "Mark", "Petrov");
                    User user2 = new User(321, "Alex", "Petrov");
                    Account[] accounts = {
                            new Account(123, 10000, user1),
                            new Account(199, 1000000, user2),
                    };
                    AccountService service = new AccountServiceMpl(accounts);

                    service.show();

                    System.out.println("Number of accounts with balance greater than:");
                    int balance = in.nextInt();
                    System.out.println(service.countAccountsWithBalanceGreaterThen(balance));
                    System.out.println("Search for account with owner id:");
                    int idToFind = in.nextInt();
                    System.out.println(service.findAccountByOwnerId(idToFind));

                    break;
                }
            }
        }while (n!=0);
        System.out.println("Good Bye");
    }
}
