package model;

import java.sql.Date;


/**
 * Created by wjk1996 on 2017/4/14.
 */
public class TeacherTable {
    private String gh;
    private String xm;
    private String xb;
    private Date csrq;
    private String xl;
    private String jbgz;
    private String yxh;
    public Date getCsrq(){
        return csrq;
    }
    public void setCsrq(Date csrq){
        this.csrq = csrq;
    }
    public String getGh(){
        return gh;
    }
    public void setGh(String gh){
        this.gh = gh;
    }
    public String getXm(){
        return xm;
    }
    public void setXm(String xm){
        this.xm = xm;
    }
    public String getXb(){
        return xb;
    }
    public void setXb(String xb){
        this.xb = xb;
    }
    public String getXl(){
        return xl;
    }
    public void setXl(String xl){
        this.xl = xl;
    }
    public String getJbgz(){
        return jbgz;
    }
    public void setJbgz(String jbgz){
        this.jbgz = jbgz;
    }
    public String getYxh(){
        return yxh;
    }
    public void setYxh(String yxh){
        this.yxh = yxh;
    }
}
