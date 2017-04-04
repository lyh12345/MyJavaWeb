package model;

/**
 * Created by lh
 * on 2017/4/3.
 */
public class AvgGPAofTerm {
    private String term;
    private double avgGPA;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getAvgGPA() {
        return avgGPA;
    }

    public void setAvgGPA(double avgGPA) {
        String str = String.valueOf(avgGPA);
        String str2;
        if(str.length()>=6){
            str2 = str.substring(0,6);
        }else {
            str2 = str;
        }
        this.avgGPA = Double.parseDouble(str2);
    }
}
