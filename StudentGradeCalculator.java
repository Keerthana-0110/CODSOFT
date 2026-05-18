import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("============================================");
        System.out.println("      ACADEMIC PERFORMANCE ANALYZER");
        System.out.println("============================================");

        // Student name
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        // Number of subjects
        System.out.print("Enter Number of Subjects: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] subjectNames = new String[n];
        int[] marks = new int[n];

        int total = 0;
        int highest = -1;
        int lowest = 101;
        String highestSubject = "";
        String lowestSubject = "";

        // Input subject names and marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Subject " + (i + 1) + " Name: ");
            subjectNames[i] = sc.nextLine();

            System.out.print("Enter Marks for " + subjectNames[i] + " (0-100): ");
            marks[i] = sc.nextInt();
            sc.nextLine();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid Marks! Enter again: ");
                marks[i] = sc.nextInt();
                sc.nextLine();
            }

            total += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
                highestSubject = subjectNames[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestSubject = subjectNames[i];
            }
        }

        // Calculate percentage
        double percentage = (double) total / n;

        // Determine grade and remark
        String grade;
        String remark;

        if (percentage >= 90) {
            grade = "A+";
            remark = "Outstanding Performance";
        } else if (percentage >= 80) {
            grade = "A";
            remark = "Excellent Work";
        } else if (percentage >= 70) {
            grade = "B";
            remark = "Very Good";
        } else if (percentage >= 60) {
            grade = "C";
            remark = "Good Effort";
        } else if (percentage >= 50) {
            grade = "D";
            remark = "Needs Improvement";
        } else {
            grade = "F";
            remark = "Requires More Practice";
        }

        // Analyze consistency
        String consistency;
        if (highest - lowest <= 10) {
            consistency = "Highly Consistent";
        } else if (highest - lowest <= 25) {
            consistency = "Moderately Consistent";
        } else {
            consistency = "Performance Varies Significantly";
        }

        // Display final report
        System.out.println("\n============================================");
        System.out.println("             STUDENT REPORT CARD");
        System.out.println("============================================");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Number of Subjects : " + n);
        System.out.println("Total Marks        : " + total);
        System.out.printf("Percentage         : %.2f%%\n", percentage);
        System.out.println("Grade              : " + grade);
        System.out.println("Remark             : " + remark);
        System.out.println("Highest Subject    : " + highestSubject + " (" + highest + ")");
        System.out.println("Lowest Subject     : " + lowestSubject + " (" + lowest + ")");
        System.out.println("Consistency        : " + consistency);
        System.out.println("============================================");

        sc.close();
    }
}