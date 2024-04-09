import java.util.Optional;

public class Main {


    public static void main(String[] args) {

        User owner = new User("demo-user", "Alexander", "Schmidt");
        Account account = new Account("123456", 1000, owner);
        // pass it into process method
        process(account);
    }

    public static void process(Account account) {
        try {
            final Optional<User> owner = Optional.ofNullable(account.getOwner());

            System.out.println(account.getCode());
            System.out.println(account.getBalance());

            owner.ifPresent(o -> {
                System.out.println(o.getLogin());
                System.out.println(o.getFirstName());
                System.out.println(o.getLastName());
            });

        } catch (Exception e) {
            System.out.println("Something wrong...");
        }
    }
}