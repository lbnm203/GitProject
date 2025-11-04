package ss18_regex.bai_tap.validate_name_of_class;

public class ClassValidateTest {
    private static ClassValidate classValidate;

    public static final String[] validClassName = new String[]{"C0223G", "A0323K"};
    public static final String[] invalidClassName = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        classValidate = new ClassValidate();
        for (String className : validClassName) {
            boolean isValid = classValidate.validate(className);
            System.out.println("Class name: " + className + " is valid: " + isValid);
        }

        for (String className : invalidClassName) {
            boolean isValid = classValidate.validate(className);
            System.out.println("Class name: " + className + " is valid: " + isValid);
        }
    }
}
