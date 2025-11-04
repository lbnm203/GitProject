package ss18_regex.thuc_hanh.validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountExample {
    private static final String ACCOUNT_PATTERN = "^[_a-z0-9]{6,}$";

    public AccountExample() {

    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACCOUNT_PATTERN);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
