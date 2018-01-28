package UserService;

import org.apache.log4j.Logger;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {

    public static final int MAX_LOG_TRY = 3;
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        UserServiceImplementation usi = new UserServiceImplementation();

        User user1 = new User("Andrzej", "Duda", "Mama1231", "adndud@gmail.com", LocalDate.parse("1994-05-06"));


        usi.register(user1);

        byte logTimes = 0;
        do {
            try {
                logTimes++;
                usi.logIn("AndDud", "qaz");
            } catch (IncorrectUserPasswordException e) {
                logger.warn("not correct password");
            }
        } while (logTimes < MAX_LOG_TRY);

        usi.changePassword(user1.getLogin(), "qaz", "qwe");
    }
}
