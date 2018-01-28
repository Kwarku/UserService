package UserService;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UserServiceImplementation usi = new UserServiceImplementation();

        User user1 = new User("Andrzej","Duda","qaz","adnrzej@gmial.com",LocalDate.parse("1990-1-24"));
        usi.register(user1);


        System.out.println(user1.getLogin());

        usi.logIn("AndDud", "qaaz");
        usi.changePassword(user1.getLogin(),"qaz","qwe");
    }
}
