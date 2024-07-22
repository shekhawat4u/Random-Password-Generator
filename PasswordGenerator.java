import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialCharacters = scanner.next().toLowerCase().charAt(0) == 'y';

        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecialCharacters);
        System.out.println("Generated password: " + password);
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeDigits, boolean includeSpecialCharacters) {
        String characterPool = "";
        if (includeUppercase) {
            characterPool += UPPERCASE;
        }
        if (includeLowercase) {
            characterPool += LOWERCASE;
        }
        if (includeDigits) {
            characterPool += DIGITS;
        }
        if (includeSpecialCharacters) {
            characterPool += SPECIAL_CHARACTERS;
        }

        if (characterPool.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be selected.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
