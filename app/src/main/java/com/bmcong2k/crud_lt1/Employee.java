package com.bmcong2k.crud_lt1;

public class Employee {

    private int img;
    private String maNV;
    private String ten;
    private String gt;

    public Employee() {
    }

    public Employee(int img, String maNV, String ten, String gt) {
        this.img = img;
        this.maNV = maNV;
        this.ten = ten;
        this.gt = gt;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }
}
