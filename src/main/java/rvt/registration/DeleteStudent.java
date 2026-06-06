package rvt.registration;

import java.util.Scanner;

public class DeleteStudent {

    public static void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the ID you want to delete: ");
        int deleteStud = scanner.nextInt();

        for (int i = 0; i < studentRegistration.studentList.size(); i++) {
            String[] parts = studentRegistration.studentList.get(i).split(",");

            if (Integer.parseInt(parts[0]) == deleteStud) {
                studentRegistration.studentList.remove(i);
                studentRegistration.updateRegistration();

                System.out.println("Student with ID " + deleteStud + " has been deleted.");
                break;
            }
        }
        scanner.close();
    }
}