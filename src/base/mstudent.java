package base;

import java.io.Serializable;

/**
 * Created by Mr.zhang on 2017/4/8.
 */
public class mstudent implements Serializable{
public mstudent(){};
private String xh;
private String xm;

private String pscj;
private String kscj;
private String zpcj;
public void setXh(String xh){
    this.xh=xh;
}
public void setXm(String xm){
    this.xm=xm;
}

public void setPscj(String pscj){
    this.pscj=pscj;
}
public void setKscj(String kscj){
    this.kscj=kscj;
}
public void setZpcj(String zpcj){
    this.zpcj=zpcj;
}
public String getXh(){
    return this.xh;
}
public String getXm(){
    return this.xm;
}

public String getPscj(){
    return this.pscj;
}
public String getKscj(){
    return this.kscj;
}
public String getZpcj(){
    return this.zpcj;
}
}
