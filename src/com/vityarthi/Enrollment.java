package com.vityarthi;

import java.io.Serializable;

public class Enrollment implements Serializable {
    private String studentId;
    private String courseCode;

    public Enrollment() {}

    public Enrollment(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
    }

    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }

    @Override
    public String toString() {
        return "Enrollment[student=" + studentId + ", course=" + courseCode + "]";
    }
}
