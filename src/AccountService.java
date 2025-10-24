interface AccountService {
    Account findAccountByOwnerId(long id);
    long countAccountsWithBalanceGreaterThen(long value);

    void show();
}
