package rvt.registration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class editStudentinfo {
    public static void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID you want to edit: ");
        int editStud = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < StudentRegistration.studentList.size(); i++) {
            String[] parts = StudentRegistration.studentList.get(i).split(",");
            if(Integer.parseInt(parts[0]) == editStud) {
                String newName;
                while (true) {
                    System.out.println("Enter new name: ");
                    newName = scanner.nextLine();
                    if (Pattern.matches(StudentRegistration.VARDA_REGEX, newName)) {
                        break;
                    } else {
                        System.out.println("Invalid name format. Please try again.");
                    }
                }
                String newSurname;
                while (true) {
                    System.out.println("Enter new surname: ");
                    newSurname = scanner.nextLine();
                    if (Pattern.matches(StudentRegistration.UZVARDA_REGEX, newSurname)) {
                        break;
                    } else {
                        System.out.println("Invalid surname format. Please try again.");
                    }
                }
                String newEmail;
                while (true) {
                    System.out.println("Enter new email: ");
                    newEmail = scanner.nextLine();
                    if (Pattern.matches(StudentRegistration.EPASTA_REGEX, newEmail)) {
                        break;
                    } else {
                        System.out.println("Invalid email format. Please try again.");
                    }
                }
                String newPersonalCode;
                while (true) {
                    System.out.println("Enter new personal code: ");
                    newPersonalCode = scanner.nextLine();
                    if (Pattern.matches(StudentRegistration.PKODA_REGEX, newPersonalCode)) {
                        break;
                    } else {
                        System.out.println("Invalid personal code format. Please try again.");
                    }
                }
                String newRegisterDate;
                while (true) {
                    System.out.println("Enter new register date (YYYY-MM-DD): ");
                    newRegisterDate = scanner.nextLine();
                    if (Pattern.matches(StudentRegistration.DATE_REGEX, newRegisterDate)) {
                        break;
                    } else {
                        System.out.println("Invalid date format. Please try again.");
                    }
                }
                String newRegisterTime;
                while (true) {
                    System.out.println("Enter new register time (HH:MM): ");
                    newRegisterTime = scanner.nextLine();
                    if (Pattern.matches(StudentRegistration.TIME_REGEX, newRegisterTime)) {
                        break;
                    } else {
                        System.out.println("Invalid time format. Please try again.");
                    }
                }

                StudentRegistration.studentList.set(i, editStud + "," + newName + "," + newSurname + "," + newEmail + "," + newPersonalCode + "," + newRegisterDate + "," + newRegisterTime);
                StudentRegistration.updateRegistration();
                System.out.println("Student with ID " + editStud + " has been edited.");
                break;
            }
        }
        scanner.close();
    }
}
