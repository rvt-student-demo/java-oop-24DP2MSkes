package rvt.registration;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

       System.out.println("What do you want to do?");
        System.out.println("1. Add student");
        System.out.println("2. Show all students");
        System.out.println("3. Edit student info");
        System.out.println("4. Delete student");
        System.out.println("5. Exit");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                StudentRegistration.studentInforegistr();
                break;

            case 2:
                ShowAllStudents.showAllStudents();
                break;

            case 3:
                editStudentinfo.edit();
                break;

            case 4:
                DeleteStudent.delete();
                break;
                
            case 5:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        scanner.close();
    }
}
