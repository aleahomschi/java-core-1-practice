package task4;

public class Account {

    private long id;
    private long balance;
    private User owner;

    private void validateID(long number) {
        if (number <=0 ) {
            throw new IllegalArgumentException("Number should be greater than 0");
        }
    }

    private void validateBalance(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }

    private void validateUser(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Object can't be null");
        }
    }

    public Account(long id, long balance, User owner) {
        validateID(id);
        validateBalance(balance);
        validateUser(owner);

        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }

    public void setId(long id) {
        validateID(id);
        this.id = id;
    }

    public void setBalance(long balance) {
        validateBalance(balance);
        this.balance = balance;
    }

    public void setOwner(User owner) {
        validateUser(owner);
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Account{id=" + id + ", balance=" + balance + ", owner=" + owner.userInfo() + "}";
    }
}
