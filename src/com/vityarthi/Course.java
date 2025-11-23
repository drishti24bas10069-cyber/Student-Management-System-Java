package com.vityarthi;

import java.io.Serializable;

public class Course implements Serializable {
    private String code;
    private String title;
    private int credits;

    public Course() {}

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }

    public void setTitle(String title) { this.title = title; }
    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String toString() {
        return "Course[code=" + code + ", title=" + title + ", credits=" + credits + "]";
    }
}
