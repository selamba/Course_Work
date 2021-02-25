package com.example.coursework;

public class CourseModel {

    private String courseName;
    private int courseRating;
    private int courseImage;

    // Constructor
    public CourseModel(String courseName, int courseRating, int courseImage) {
        this.courseName = courseName;
        this.courseRating = courseRating;
        this.courseImage = courseImage;
    }

    // Getter and Setter
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(int courseRating) {
        this.courseRating = courseRating;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }
}
