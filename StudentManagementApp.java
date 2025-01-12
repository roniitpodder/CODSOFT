package pack1;
import java.util.Scanner;
public class StudentManagementApp {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem sms = new StudentManagementSystem();
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
    private static void displayMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
    }
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }
    private static void addStudent() {
        scanner.nextLine();  
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        int rollNumber = getIntInput("Enter roll number: ");
        scanner.nextLine();  
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        Student student = new Student(name, rollNumber, grade);
        sms.addStudent(student);
        System.out.println("Student added successfully.");
    }
    private static void removeStudent() {
        int rollNumber = getIntInput("Enter the roll number of the student to remove: ");
        sms.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }
    private static void searchStudent() {
        int rollNumber = getIntInput("Enter the roll number to search: ");
        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }
}