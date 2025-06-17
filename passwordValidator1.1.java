import java.util.Scanner;

public class passwordValidator5 {

    public static boolean isLengthValid(String password) {
        return password.length() >= 8;
    }

    public static boolean hasUppercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLowercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter at least 8 length password: ");
            String password = scanner.nextLine();

            boolean lengthValid = isLengthValid(password); // at least 8 long
            boolean hasUppercase = hasUppercase(password);
            boolean hasLowercase = hasLowercase(password);
            boolean hasDigit = hasDigit(password);
            boolean hasSpecialChar = hasSpecialChar(password);

            if (lengthValid && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
                System.out.println("Password is strong.");
            } else {
                System.out.println("Password is weak. please enter tere conditions");
                if (!lengthValid) System.out.println("-  8 characters long");
                if (!hasUppercase) System.out.println("- Contains uppercase letter");
                if (!hasLowercase) System.out.println("- Contains at lowercase letter");
                if (!hasDigit) System.out.println("- Contains at digit");
                if (!hasSpecialChar) System.out.println("- Contains at least one special character");
            }

            scanner.close();
        }


}
