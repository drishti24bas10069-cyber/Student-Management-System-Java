package com.vityarthi;

import java.io.Serializable;

public class Result implements Serializable {
    private String studentId;
    private String courseCode;
    private String grade;

    public Result() {}

    public Result(String studentId, String courseCode, String grade) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
    }

    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public String getGrade() { return grade; }

    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return "Result[student=" + studentId + ", course=" + courseCode + ", grade=" + grade + "]";
    }
}
