package ss18_regex.bai_tap.validate_name_of_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassValidate {
    private static final String CLASS_NAME_PATTERN = "^[CAP][0-9]{4}[GHIK]$";

    public ClassValidate() {

    }

    public boolean validate(String className) {
        Pattern pattern = Pattern.compile(CLASS_NAME_PATTERN);
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }
}