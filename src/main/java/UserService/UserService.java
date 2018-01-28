package UserService;

public interface UserService {

    void register(User user);

    void logIn(String login, String password) throws IncorrectUserPasswordException;

    void changePassword(String login,String oldPassword, String newPassword);
}
