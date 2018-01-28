package UserService;

public interface UserService {

    void register(User user);

    void logIn(String login, String password);

    void changePassword(String login,String oldPassword, String newPassword);
}
