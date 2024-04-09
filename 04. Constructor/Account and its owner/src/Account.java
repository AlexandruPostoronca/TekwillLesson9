public class Account {

    private final String code;
    private final long balance;
    private final User owner;

    public Account(String code, long balance, User owner) {
        this.code = code;
        this.balance = balance;
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
}