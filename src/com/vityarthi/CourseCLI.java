package com.vityarthi;

import java.util.Scanner;

public class CourseCLI {
    private Scanner sc;
    private Store store;

    public CourseCLI(Scanner sc, Store store) {
        this.sc = sc;
        this.store = store;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. List Courses");
            System.out.println("5. Back");
            System.out.print("Choose: ");

            String c = sc.nextLine().trim();
            switch (c) {
                case "1": add(); break;
                case "2": update(); break;
                case "3": delete(); break;
                case "4": list(); break;
                case "5": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void add() {
        System.out.print("Course Code: ");
        String code = sc.nextLine().trim();

        System.out.print("Course Title: ");
        String title = sc.nextLine().trim();

        System.out.print("Credits: ");
        int credits = Integer.parseInt(sc.nextLine().trim());

        store.addCourse(new Course(code, title, credits));
        System.out.println("Course added.");
    }

    private void update() {
        System.out.print("Course Code: ");
        String code = sc.nextLine().trim();

        Course c = store.getCourseByCode(code);
        if (c == null) {
            System.out.println("Course not found!");
            return;
        }

        System.out.print("New Title (leave empty to skip): ");
        String title = sc.nextLine().trim();

        System.out.print("New Credits (leave empty to skip): ");
        String cr = sc.nextLine().trim();

        if (!title.isEmpty()) c.setTitle(title);
        if (!cr.isEmpty()) c.setCredits(Integer.parseInt(cr));

        System.out.println("Course updated.");
    }

    private void delete() {
        System.out.print("Course Code: ");
        String code = sc.nextLine().trim();

        store.removeCourse(code);
        System.out.println("Course deleted (if existed).");
    }

    private void list() {
        System.out.println("\n--- All Courses ---");
        store.getAllCourses().forEach(System.out::println);
    }
}
