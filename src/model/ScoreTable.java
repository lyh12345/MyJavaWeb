package model;

/**
 * Created by lh
 * on 2017/3/31.
 */
public class ScoreTable {
    private String courseId;
    private String courseName;
    private int courseCredit;
    private double courseGrade;
    private double courseGPA;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public double getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(double courseGrade) {
        this.courseGrade = courseGrade;
        if(this.courseGrade>=90){
            courseGPA = 4;
        }
        else if(this.courseGrade>=85){
            courseGPA = 3.7;
        }
        else if(this.courseGrade>=82){
            courseGPA = 3.3;
        }
        else if(this.courseGrade>=78){
            courseGPA = 3.0;
        }
        else if(this.courseGrade>=75){
            courseGPA = 2.7;
        }
        else if(this.courseGrade>=72){
            courseGPA = 2.3;
        }
        else if(this.courseGrade>=68){
            courseGPA = 2.0;
        }
        else if(this.courseGrade>=66){
            courseGPA = 1.7;
        }
        else if(this.courseGrade>=64){
            courseGPA = 1.5;
        }
        else if(this.courseGrade>=60){
            courseGPA = 1.0;
        }
        else{
            courseGPA = 0;
        }
    }

    public double getCourseGPA() {
        return courseGPA;
    }

}
