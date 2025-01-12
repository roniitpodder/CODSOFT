package pack1;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.txt";
    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }
    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
    }
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        saveStudentsToFile();
    }
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    private void loadStudentsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int rollNumber = Integer.parseInt(parts[1]);
                String grade = parts[2];
                Student student = new Student(name, rollNumber, grade);
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data from file.");
        }
    }
    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving student data to file.");
        }
    }
}