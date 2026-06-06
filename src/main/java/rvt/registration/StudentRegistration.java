package rvt.registration;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

import rvt.OnlineShop.shoppingCart;

public class StudentRegistration {
    public static ArrayList<String> studentList = new ArrayList<>(); // List to store student information
    private static final String filePath = "src/main/java/registration/registr.csv"; // File path to store student information

    public static final String VARDA_REGEX = "^[A-Za-zĀČĒĢĪĶĻŅŠŪŽāčēģīķļņšūž\\s-]{1,60}$";
    public static final String UZVARDA_REGEX = "^[A-Za-zĀČĒĢĪĶĻŅŠŪŽāčēģīķļņšūž\\s-]{1,100}$";
    public static final String PKODA_REGEX = "^\\d{6}-\\d{5}$";
    public static final String EPASTA_REGEX = "^[A-Za-z0-9+_.-]{1,64}@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    public static final String TIME_REGEX = "^\\d{2}:\\d{2}$";


    public static void addStudent(String name, String surname, String email,
                       String personalCode, String registerDate, String registerTime) {

    int newId = getLastId() + 1;

    String newStudent = newId + "," + name + "," + surname + "," +
                        email + "," + personalCode + "," +
                        registerDate + "," + registerTime;

    studentList.add(newStudent); 

    updateRegistration(); 

    System.out.println("Student added successfully!");
}


    

   public static void studentInforegistr()  { 
    Scanner scanner = new Scanner(System.in);
    String name;
    while (true) {
        System.out.print("Write a student name: ");
        name = scanner.nextLine();
        if (Pattern.matches(VARDA_REGEX, name)) {
            break;
        } else {
            System.out.println("Invalid name format. Please try again.");
        }
    }
    String surname;
    while (true) {
        System.out.print("Write a student surname: ");
        surname = scanner.nextLine();
        if (Pattern.matches(UZVARDA_REGEX, surname)) {
            break;
        } else {
            System.out.println("Invalid surname format. Please try again.");
        }
    }
    String email;
    while (true) {
        System.out.print("Write a student email: ");
        email = scanner.nextLine();
        if (Pattern.matches(EPASTA_REGEX, email)) {
            break;
        } else {
            System.out.println("Invalid email format. Please try again.");
        }
    }
    String personalCode;
    while (true) {
        System.out.print("Write a student personal code: ");
        personalCode = scanner.nextLine();
        if (Pattern.matches(PKODA_REGEX, personalCode)) {
            break;
        } else {
            System.out.println("Invalid personal code format. Please try again.");
        }
    }
    String registerDate;
    while (true) {
        System.out.print("Write register date (YYYY-MM-DD): ");
        registerDate = scanner.nextLine();
        if (Pattern.matches(DATE_REGEX, registerDate)) {
            break;
        } else {
            System.out.println("Invalid date format. Please try again.");
        }
    }
    String registerTime;
    while (true) {
        System.out.print("Write registration time (HH:MM): ");
        registerTime = scanner.nextLine();
        if (Pattern.matches(TIME_REGEX, registerTime)) {
            break;
        } else {
            System.out.println("Invalid time format. Please try again.");
        }
    }

    addStudent(name, surname, email, personalCode, registerDate, registerTime);
    scanner.close();
}
public StudentRegistration() { // Constructor to initialize the student list and load existing student information from the file
    loadStudentInfo();

}

private void loadStudentInfo() { // Method to load existing student info from the file and add it to the list 
    try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean isFirstLine = true;
        while((line = reader.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }

            if (!line.trim().isEmpty()) { //Check if the line is not empty before adding it to the list 
        studentList.add(line);
                }
            
        }
    } catch (IOException e) {
        System.out.println("An error occurred while loading student information: " + e.getMessage());
    }
}




public static int getLastId() { // Method to get the last ID from the student list to assign a new ID to the next student being added
        if (studentList.isEmpty()) {
            return 0;
        }

        String lastLine = studentList.get(studentList.size() - 1); // Get the last line from the student list
        String[] parts = lastLine.split(","); // Split the line by comma to extract the ID part to parts 
        return Integer.parseInt(parts[0]); // Return the ID part as an integer to be used for the next student being added
    }

    public static void updateRegistration() { // Method to write the updated student list to the file after adding a new student 
        try {
            BufferedWriter writer = new BufferedWriter( // write updated student list to the file 
                    new FileWriter(filePath));

            writer.write("id,name,surname,email,personalCode,registerDate,registerTime"); // Write the header line to the file 
            writer.newLine(); 

            for (String student : studentList) { // Write each student info from the student list to the file 
                writer.write(student); // Write the student info to the file 
                writer.newLine();
            }

            writer.close(); // Close the writer after writing to the file
        } catch (IOException e) {
            System.out.println(
                "An error occurred while writing the file: "
                + e.getMessage());
        }
    }

}

  
