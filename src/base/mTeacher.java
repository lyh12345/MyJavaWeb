package base;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Mr.zhang on 2017/4/3.
 */
public class mTeacher implements Serializable{
    public mTeacher(){}
    private String gh;
    private String xm;
    private String xb;
    private Date csrq;
    private String xl;
    private Double jbgz;
    private String yxh;
    private String pwd;

    public String getgh() {
        return this.gh;
    }

    public String getXm() {
        return this.xm;
    }

    public String getXb() {
        return this.xb;
    }

    public String getXl() {
        return this.xl;
    }

    public String getYxh() {
        return this.yxh;
    }

    public String getPwd() {
        return this.pwd;
    }

    public Date getCsrq() {
        return this.csrq;
    }

    public Double getjbgz() {
        return this.jbgz;
    }
    public void setGh(String gh){
        this.gh=gh;
    }
    public void setXm(String xm){
        this.xm=xm;
    }
    public void setXb(String xb){
        this.xb=xb;
    }
    public void setCsrq(Date csrq){
        this.csrq=csrq;
    }
    public void setXl(String xl){
        this.xl=xl;
    }
    public void setJbgz(Double jbgz){
        this.jbgz=jbgz;
    }
    public void setYxh(String yxh){
        this.yxh=yxh;
    }
    public void setPwd(String pwd){
        this.pwd=pwd;
    }
}
