package task4;

public interface AccountService {
    Account findAccountByOwnerId(long id);

    long countAccountsWithBalanceGreaterThan(long value);

    void show();
}
