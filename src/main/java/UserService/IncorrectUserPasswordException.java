package UserService;

public class IncorrectUserPasswordException extends Exception {
    public IncorrectUserPasswordException(String msg){
        super(msg);

    }

}
