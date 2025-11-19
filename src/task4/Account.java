package task4;

public class Account {

    private long id;
    private long balance;
    private User owner;

    private void validateNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number should be greater than 0");
        }
    }

    private void validateObject(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Object can't be null");
        }
    }

    public Account(long id, long balance, User owner) {
        validateNumber(id);
        validateNumber(balance);
        validateObject(owner);

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
        validateNumber(id);
        this.id = id;
    }

    public void setBalance(long balance) {
        validateNumber(balance);
        this.balance = balance;
    }

    public void setOwner(User owner) {
        validateObject(owner);
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Account{id=" + id + ", balance=" + balance + ", owner=" + owner.userInfo() + "}";
    }
}
