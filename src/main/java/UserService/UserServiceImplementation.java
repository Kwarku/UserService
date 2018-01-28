package UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserServiceImplementation implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImplementation.class.getName());

    private List<User> users = new ArrayList<>();


    @Override
    public void register(User user) {
        users.add(user);
        showSuccessLogger(user, " is register");
    }

    @Override
    public void logIn(String login, String password) {
        for (User user : users) {
            if (isLoginCorrect(user, login)) {
                if (isPasswordCorrect(user, password)) {
                    showSuccessLogger(user, " is log in ");
                } else {
                    showWarningLogger(user, " is not log in, Not same password");
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
        logger.warning("user with this login dose not exist");
    }

    private void showWarningLogger(User user, String msg) {
        logger.warning("user " + user.getId() + msg);
    }

    private void showSuccessLogger(User user, String msg) {
        logger.info("user " + user.getId() + msg);
    }


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
