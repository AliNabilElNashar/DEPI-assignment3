import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Student student = new Student();

        if (student.login(input)) {
            student.collectUserData(input);
            student.printStudentData();
        }

        input.close();
    }
}

class Student {
    private String email;

    private String secretCode;
    private String fullName;
    private int age;
    private int marks;
    private char grade;


    public boolean login(Scanner input) {
        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Enter your Email: ");
            email = input.nextLine();
            System.out.print("Enter your Password: ");
            String password = input.nextLine();

            String correctEmail = "mohamed@intrast.com";
            String correctPassword = "mohamed123";
            if (email.equals(correctEmail) && password.equals(correctPassword)) {
                System.out.println("Login successful! Welcome.");
                return true;
            } else {
                System.out.println("Invalid email or password. Attempt " + attempts + " of 3.");
            }
        }
        System.out.println("Too many failed attempts. Account locked.");
        return false;
    }

    public void collectUserData(Scanner input) {
        System.out.print("Enter your secret code: ");
        secretCode = input.nextLine();

        System.out.print("Enter your full name: ");
        fullName = input.nextLine();

        System.out.print("Enter your age: ");
        age = input.nextInt();

        for (int i = 1; true; i++) {
            System.out.print("Enter your marks (0–100): ");
            if (input.hasNextInt()) {
                marks = input.nextInt();
                if (marks >= 0 && marks <= 100) {
                    calculateGrade();
                    break;
                } else {
                    System.out.println("Invalid marks. Must be between 0 and 100. Attempt " + i + " of 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number. Attempt " + i + " of 3.");
                input.next();
            }

            if (i == 3) {
                System.out.println("Too many invalid attempts. Exiting.");
                marks = -1;
                break;
            }
        }
        input.nextLine();
    }

    private void calculateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 70) grade = 'C';
        else if (marks >= 60) grade = 'D';
        else grade = 'F';
    }

    public void printStudentData() {
        System.out.println("\n=== Student Information ===");
        System.out.println("Email: " + email);
        System.out.println("Secret Code: " + secretCode);
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        if (marks == -1) {
            System.out.println("Grade: Invalid marks entered. No letter grade assigned.");
        } else {
            System.out.println("Marks: " + marks);
            System.out.println("Letter Grade: " + grade);

            switch (grade) {
                case 'A' -> System.out.println("Excellent work!");
                case 'B' -> System.out.println("Great job!");
                case 'C' -> System.out.println("Good effort!");
                case 'D' -> System.out.println("You passed, but aim higher.");
                case 'F' -> System.out.println("You need to improve.");
            }
        }
    }
}
