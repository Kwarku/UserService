package UserService;

import java.time.LocalDate;

public class User {
    private static int idNumber = 1000;

    private final int id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String eMail;
    private LocalDate dateOfBirth;


    public User(String name, String lastName, String password) {
        this(name, lastName, password, "  ", LocalDate.now());
    }

    public User(String name, String lastName, String password, String eMail, LocalDate dateOfBirth) {
        User.idNumber++;

        id = User.idNumber;
        this.name = name;
        this.lastName = lastName;
        this.login = name.substring(0, 3) + lastName.substring(0, 3);
        this.password = password;
        this.eMail = eMail;
        this.dateOfBirth = dateOfBirth;


    }


    //GETTERS SETTERS
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
