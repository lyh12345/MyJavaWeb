package base;

import java.io.Serializable;

/**
 * Created by Mr.zhang on 2017/4/7.
 */
public class Tclass implements Serializable{
    public Tclass(){}
   private String xq;
    private String name;
   private String kh;
   private String gh;
   private String sksj;
   public String getName(){return this.name;}
   public void setName(String name){this.name=name;}
   public String getXq(){
       return this.xq;
   }
   public String getKh(){
       return this.kh;
   }
   public String getGh(){
       return this.gh;
   }
   public String getSksj(){
       return this.sksj;
   }
   public void setxq(String xq){
       this.xq=xq;
   }
   public void setKh(String kh){
       this.kh=kh;
   }
   public void setGh(String gh){
       this.gh=gh;
   }
   public void setSksj(String sksj){
       this.sksj=sksj;
   }
}
