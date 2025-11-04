package ss18_regex.bai_tap.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private static final String PHONE_NUMBER_PATTERN = "^\\((84)\\)\\-\\([0-9]{10}\\)$";

    public PhoneNumber() {

    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
