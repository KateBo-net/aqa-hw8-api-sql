package data;

public class VerifyInfo {
    private String login;
    private String code;

    public VerifyInfo(String login, String code) {
        this.login = login;
        this.code = code;
    }

    public String getLogin() {
        return login;
    }

    public String getCode() {
        return code;
    }
}
