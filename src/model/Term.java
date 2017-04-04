package model;

/**
 * Created by lh
 * on 2017/4/2.
 */
public class Term {
    private String term;
    private double avgGPA;
    public String getTerm(){
        return term;
    }
    public void setTerm(String str){
        term = str;
    }

    public double getAvgGPA() {
        return avgGPA;
    }

    public void setAvgGPA(double avgGPA) {
        this.avgGPA = avgGPA;
    }
}
