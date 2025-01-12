import java.util.Scanner;

public class assignment1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            if (age <= 0) {
                System.out.println("Age must be a positive integer. Please try again.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Enter your GPA: ");
            double gpa = scanner.nextDouble();

            if (gpa < 0 || gpa > 4) {
                System.out.println("GPA must be between 0.0 and 4.0. Please try again.");
                scanner.nextLine();
                continue;
            }

            System.out.print("Enter your number of completed credits: ");
            int credits = scanner.nextInt();

            System.out.print("Enter your weekly hours spent studying for subject 1: ");
            double subject1 = scanner.nextDouble();

            System.out.print("Enter your weekly hours spent studying for subject 2: ");
            double subject2 = scanner.nextDouble();

            System.out.print("Enter your weekly hours spent studying for subject 3: ");
            double subject3 = scanner.nextDouble();

            System.out.print("Enter your weekly hours spent studying for subject 4: ");
            double subject4 = scanner.nextDouble();

            System.out.print("Enter your weekly hours spent studying for subject 5: ");
            double subject5 = scanner.nextDouble();

            double average = ((subject1 + subject2 + subject3 + subject4 + subject5) / 7);
            int remainingCredits = (120 - credits);
            double semester = ((subject1 + subject2 + subject3 + subject4 + subject5) * 16);

            // Output the data
            System.out.println("\n--- Student Summary ---");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("GPA: " + gpa + ".");
            System.out.println("Completed Credits: " + credits);
            System.out.println("Remaining Credits: " + remainingCredits);
            System.out.println("Average study hours per day: " + average);
            System.out.println("Total study hours per semester: " + semester);

            isValid = true;
        }

        scanner.close();
    }
}