package UserService;

import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserServiceImplementation implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImplementation.class.getName());
    private static final int ADULT_AGE = 18;
    private static final int MIN_PASSWORD_LENGTH = 8;

    private List<User> users = new ArrayList<>();


    @Override
    public void register(User user) {
        if (isUserLoginUnique(user.getLogin()) && isPasswordStrongEnough(user.getPassword())) {
            addUser(user);
        }
    }


    private void addUser(User user) {
        if (isUserUnder18(user)) {
            users.add(user);
            showSuccessLogger(user, " is register");

        }
    }

    private boolean isUserUnder18(User user) {
        if (user.getDateOfBirth().isBefore(LocalDate.now().minusYears(ADULT_AGE))) {
            return true;
        }
        showWarningLogger(user, " is under " + ADULT_AGE);
        return false;

    }

    private boolean isPasswordStrongEnough(String password) {
        Pattern pattern = Pattern.compile("(([A-Z].*[0-9]))");
        Matcher matcher = pattern.matcher(password);
        if (matcher.find() && password.length() >= MIN_PASSWORD_LENGTH) {
            return true;
        }
        showLogg("password is not strong");
        return false;

    }

    private boolean isUserLoginUnique(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }


    //TODO refactor this
    @Override
    public void logIn(String login, String password) throws IncorrectUserPasswordException {
        for (User user : users) {
            if (isLoginCorrect(user, login)) {
                if (isPasswordCorrect(user, password)) {
                    showSuccessLogger(user, " is log in ");
                } else {
                    showWarningLogger(user, " is not log in, Not same password");
                    throw new IncorrectUserPasswordException("error : password is not equals");

                }
            } else {
                userNotExistLogger();
            }
        }
    }


    private boolean isLoginCorrect(User user, String login) {
        if (user.getLogin().equals(login)) {
            return true;
        }
        return false;
    }

    private boolean isPasswordCorrect(User user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    private void userNotExistLogger() {
        logger.warn("user with this login dose not exist");
    }

    private void showLogg(String msg) {
        logger.warn(msg);
    }

    private void showWarningLogger(User user, String msg) {
        logger.warn("user " + user.getId() + msg);
    }

    private void showSuccessLogger(User user, String msg) {
        logger.info("user " + user.getId() + msg);
    }


    //TODO refactor this
    @Override
    public void changePassword(String login, String oldPassword, String newPassword) {
        for (User user : users) {
            if (isLoginCorrect(user, login)) {
                if (isPasswordCorrect(user, oldPassword)) {
                    user.setPassword(newPassword);
                    showSuccessLogger(user, "password changed successfully");
                } else {
                    showWarningLogger(user, "password cant changed, this password is not user password");
                }
            } else {
                userNotExistLogger();
            }
        }
    }



}
