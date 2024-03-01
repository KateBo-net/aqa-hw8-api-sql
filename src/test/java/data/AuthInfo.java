package data;

public class AuthInfo {
    private String login;
    private String password;

    public AuthInfo(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
