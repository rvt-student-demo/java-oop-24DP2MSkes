package rvt.registration;

public class ShowAllStudents {
    public static void showAllStudents() {

    System.out.println("+----+----------+----------+----------------------+--------------+------------+----------+");
    System.out.println("| ID | Name     | Surname  | Email                | Pers. Code   | Date       | Time     |");
    System.out.println("+----+----------+----------+----------------------+--------------+------------+----------+");

    for (String student : StudentRegistration.studentList) {
        String[] data = student.split(",");

        String id = data[0];
        String name = data[1];
        String surname = data[2];
        String email = data[3];
        String personalCode = data[4];
        String date = data[5];
        String time = data[6];

        System.out.printf("| %-2s | %-8.8s | %-8.8s | %-20.20s | %-12s | %-10s | %-8s |\n",
                id, name, surname, email, personalCode, date, time);
    }

    System.out.println("+----+----------+----------+----------------------+--------------+------------+----------+");
}
}
