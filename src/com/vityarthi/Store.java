package com.vityarthi;

import java.io.*;
import java.util.*;

public class Store {
    private static Store instance;

    private Map<String, Student> students = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();
    private List<Enrollment> enrollments = new ArrayList<>();
    private List<Result> results = new ArrayList<>();

    private final String dataDir = "data";

    private Store() {
        new File(dataDir).mkdirs();
    }

    public static Store getInstance() {
        if (instance == null) instance = new Store();
        return instance;
    }

    // STUDENTS
    public void addStudent(Student s) { students.put(s.getId(), s); }
    public Student getStudentById(String id) { return students.get(id); }
    public Collection<Student> getAllStudents() { return students.values(); }
    public void removeStudent(String id) { students.remove(id); }

    // COURSES
    public void addCourse(Course c) { courses.put(c.getCode(), c); }
    public Course getCourseByCode(String code) { return courses.get(code); }
    public Collection<Course> getAllCourses() { return courses.values(); }
    public void removeCourse(String code) { courses.remove(code); }

    // ENROLLMENTS
    public void enroll(String sid, String code) {
        enrollments.add(new Enrollment(sid, code));
    }

    public List<Enrollment> getEnrollments() { return enrollments; }

    // RESULTS
    public void addOrUpdateResult(Result r) {
        for (Result x : results) {
            if (x.getStudentId().equals(r.getStudentId()) && x.getCourseCode().equals(r.getCourseCode())) {
                x.setGrade(r.getGrade());
                return;
            }
        }
        results.add(r);
    }

    public List<Result> getResults() { return results; }

    // PRINT HELPERS
    public void printEnrollmentsForStudent(String sid) {
        enrollments.stream()
                .filter(e -> e.getStudentId().equals(sid))
                .forEach(System.out::println);
    }

    public void printResultsForStudent(String sid) {
        results.stream()
                .filter(r -> r.getStudentId().equals(sid))
                .forEach(System.out::println);
    }

    // PERSISTENCE
    public void saveAll() {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(dataDir + "/store.dat"))) {
            o.writeObject(students);
            o.writeObject(courses);
            o.writeObject(enrollments);
            o.writeObject(results);
            System.out.println("Data saved.");
        } catch (Exception e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    public void loadAll() {
        File f = new File(dataDir + "/store.dat");
        if (!f.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            students = (Map<String, Student>) in.readObject();
            courses = (Map<String, Course>) in.readObject();
            enrollments = (List<Enrollment>) in.readObject();
            results = (List<Result>) in.readObject();
            System.out.println("Data loaded.");
        } catch (Exception e) {
            System.out.println("Load error: " + e.getMessage());
        }
    }
}
