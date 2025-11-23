package com.vityarthi;

import java.util.Scanner;
import java.util.UUID;

public class StudentCLI {
    private Scanner sc;
    private Store store;

    public StudentCLI(Scanner sc, Store store) {
        this.sc = sc;
        this.store = store;
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. List Students");
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
        String id = "S" + UUID.randomUUID().toString().substring(0,5);
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        store.addStudent(new Student(id, name, email));
        System.out.println("Student added with ID: " + id);
    }

    private void update() {
        System.out.print("Student ID: ");
        String id = sc.nextLine().trim();

        Student s = store.getStudentById(id);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("New Name (leave empty to skip): ");
        String name = sc.nextLine().trim();

        System.out.print("New Email (leave empty to skip): ");
        String email = sc.nextLine().trim();

        if (!name.isEmpty()) s.setName(name);
        if (!email.isEmpty()) s.setEmail(email);

        System.out.println("Student updated.");
    }

    private void delete() {
        System.out.print("Student ID: ");
        String id = sc.nextLine().trim();

        store.removeStudent(id);
        System.out.println("Student deleted (if existed).");
    }

    private void list() {
        System.out.println("\n--- All Students ---");
        store.getAllStudents().forEach(System.out::println);
    }
}
