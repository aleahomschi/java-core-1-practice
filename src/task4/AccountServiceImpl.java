package task4;

import java.util.logging.Logger;

public class AccountServiceImpl implements AccountService {
    private final Account[] accounts;
    private static final Logger log = Logger.getLogger(AccountServiceImpl.class.getName());

    private void validateNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number should be greater than 0");
        }
    }

    private void validateAccountArray(Account[] accounts) {
        if (accounts == null || accounts.length == 0) {
            throw new IllegalArgumentException("Accounts array cannot be null or empty.");
        }
    }

    public AccountServiceImpl(Account[] accounts) {
        validateAccountArray(accounts);
        this.accounts = accounts;
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        validateNumber(id);

        if (accounts == null) {
            throw new IllegalArgumentException("Array with accounts is null");
        }

        for (Account i : accounts) {
            if (i != null && i.getOwner() != null) {
                if (id == i.getOwner().getId()) {
                    log.info("Found account with owner ID: " + id);
                    return i;
                }
            }
        }
        log.info("No account found with owner ID: " + id);
        return null;
    }


    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        validateNumber(value);

        if (accounts == null) {
            throw new IllegalArgumentException("Array with accounts is null");
        }

        int num = 0;
        for (Account a : accounts) {
            if (a != null && a.getBalance() >value) {
                    num++;
            }
        }
        log.info("Count of accounts with balance greater than " + value + ": " + num);
        return num;
    }


    public void show() {
        if (accounts == null) {
            log.warning("Cannot show accounts: array is null.");
            return;
        }

        for (Account a : accounts) {
            if (a != null && a.getOwner() != null) {
                log.info("ID: " + a.getId() + ". Balance: " + a.getBalance() + ". Owner Info: " + a.getOwner().userInfo());
            } else {
                log.warning("Skipping null account or account with null owner.");
            }
        }
    }
}