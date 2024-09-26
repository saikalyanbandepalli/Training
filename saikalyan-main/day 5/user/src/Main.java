import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        String email;
        String password;
        int age;
        Scanner s = new Scanner(System.in);

        try {
            System.out.println("Enter your name:");
            name = s.nextLine();

            System.out.println("Enter your email:");
            email = s.nextLine();

            System.out.println("Enter your password:");
            password = s.nextLine();

            System.out.println("Enter your age:");
            age = s.nextInt();

            int length = password.length();
            if (length < 8) {
                throw new Exception("Password must be at least 8 characters long");
            }

            if (age < 8) {
                throw new Exception("Age must be at least 8");
            }

            System.out.println("Registration successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            s.close();
        }
    }
}
