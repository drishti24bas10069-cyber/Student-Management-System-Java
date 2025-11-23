package com.vityarthi;

import java.util.Scanner;

public class ResultCLI {
    private Scanner sc;
    private Store store;

    public ResultCLI(Scanner sc, Store store) {
        this.sc = sc;
        this.store = store;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Enrollment & Results ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. Add/Update Result");
            System.out.println("3. List Enrollments");
            System.out.println("4. List Results");
            System.out.println("5. Back");
            System.out.print("Choose: ");

            String c = sc.nextLine().trim();

            switch (c) {
                case "1": enroll(); break;
                case "2": addResult(); break;
                case "3": listEnrollments(); break;
                case "4": listResults(); break;
                case "5": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void enroll() {
        System.out.print("Student ID: ");
        String sid = sc.nextLine().trim();

        System.out.print("Course Code: ");
        String code = sc.nextLine().trim();

        store.enroll(sid, code);
        System.out.println("Student enrolled.");
    }

    private void addResult() {
        System.out.print("Student ID: ");
        String sid = sc.nextLine().trim();

        System.out.print("Course Code: ");
        String code = sc.nextLine().trim();

        System.out.print("Grade (A/B/C/D/F): ");
        String g = sc.nextLine().trim();

        store.addOrUpdateResult(new Result(sid, code, g));
        System.out.println("Result saved.");
    }

    private void listEnrollments() {
        System.out.println("\n--- All Enrollments ---");
        store.getEnrollments().forEach(System.out::println);
    }

    private void listResults() {
        System.out.println("\n--- All Results ---");
        store.getResults().forEach(System.out::println);
    }
}
