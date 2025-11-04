package ss18_regex.bai_tap.validate_phone_number;

public class PhoneNumberTest {
    private static PhoneNumber phoneNumber;

    public static final String[] validPhoneNumber = new String[]{"(84)-(0341234567)", "(84)-(0341245678)"};
    public static final String[] invalidPhoneNumber = new String[]{"(84)-(03412345)", "(84)-(034123456789)", "(84)-(0341234567890)"};

    public static void main(String[] args) {
        phoneNumber = new PhoneNumber();
        for (String number : validPhoneNumber) {
            boolean isValid = phoneNumber.validate(number);
            System.out.println("Phone number is " + number + " is valid: " + isValid);
        }

        for (String number : invalidPhoneNumber) {
            boolean isValid = phoneNumber.validate(number);
            System.out.println("Phone number is " + number + " is valid: " + isValid);
        }
    }
}
