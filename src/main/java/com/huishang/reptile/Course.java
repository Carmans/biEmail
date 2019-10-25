package com.huishang.reptile;

/**
 * 课程类
 * @author zhang_fei
 * @create 2019-10-23 15:48
 */
public class Course {

    private int id;
    private String title;
    private double oriPrice;
    private double salePrice;
    private String lecturer;
    private String  Peop;
    private String TecRreq;
    private String EnvPara;

    public String getPeop() {
        return Peop;
    }

    public void setPeop(String peop) {
        Peop = peop;
    }

    public String getTecRreq() {
        return TecRreq;
    }

    public void setTecRreq(String tecRreq) {
        TecRreq = tecRreq;
    }

    public String getEnvPara() {
        return EnvPara;
    }

    public void setEnvPara(String envPara) {
        EnvPara = envPara;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(double oriPrice) {
        this.oriPrice = oriPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", salePrice=" + salePrice + "\t" +
                ", title='" + title + '\'' +
                ", oriPrice=" + oriPrice +
                 ", lecturer='" + lecturer + '\'' +
                ",Peop='"+Peop+'\''+
                ",TecRreq='"+TecRreq+'\''+
                ",EnvPara='"+EnvPara+'\''+
                '}';
    }
}
