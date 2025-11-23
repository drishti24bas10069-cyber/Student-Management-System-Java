package com.vityarthi;

import java.util.Scanner;

public class App {
    private final Scanner sc = new Scanner(System.in);
    private final Store store = Store.getInstance();

    public void start() {
        store.loadAll();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            String c = sc.nextLine().trim();

            switch (c) {
                case "1": adminMenu(); break;
                case "2": studentMenu(); break;
                case "3": store.saveAll(); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void adminMenu() {
        System.out.print("Enter admin password: ");
        String pw = sc.nextLine().trim();

        if (!pw.equals("admin123")) {
            System.out.println("Wrong password!");
            return;
        }

        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment & Results");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            String c = sc.nextLine().trim();
            switch (c) {
                case "1": new StudentCLI(sc, store).menu(); break;
                case "2": new CourseCLI(sc, store).menu(); break;
                case "3": new ResultCLI(sc, store).menu(); break;
                case "4": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void studentMenu() {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine().trim();

        Student s = store.getStudentById(id);

        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View Profile");
            System.out.println("2. View Enrollments");
            System.out.println("3. View Results");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            String c = sc.nextLine().trim();
            switch (c) {
                case "1": System.out.println(s); break;
                case "2": store.printEnrollmentsForStudent(id); break;
                case "3": store.printResultsForStudent(id); break;
                case "4": return;
                default: System.out.println("Invalid option.");
            }
        }
    }
}
