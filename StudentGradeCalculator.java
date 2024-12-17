import java.util.*;
public class StudentGradeCalculator {
    public static String gradeCal(double perct) {
        if (perct>=90){
            return "O";
        }
        else if (perct>=80){
            return "A";
        }
        else if (perct>=70){
            return "B";
        }
        else if (perct>=60){
            return "C";
        }
        else if (perct>=50){
            return "D";
        }
        else if (perct>=40){
            return "E";
        }
        else{
            return "F";
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("STUDENT GRADE CALCULATOR ");
        System.out.print("Enter Number Of Subjects: ");
        int sub=sc.nextInt();
        int totalmarks=0;
        for (int i=1;i<=sub;i++){
            System.out.println("Enter Marks in Subject No. "+i+", out of 100");
            int marks=sc.nextInt();
            totalmarks+=marks;
        }
        sc.close();
        double avg=(double)(totalmarks/sub);
        String grade=gradeCal(avg);
        System.out.println("--- RESULTS ---");
        System.out.println("Total Marks obtained : "+totalmarks);
        System.out.printf("Average Percentage : %.2f",avg);
        System.out.println(" %");
        System.out.println("Grade Obtained : "+grade);
    }
}