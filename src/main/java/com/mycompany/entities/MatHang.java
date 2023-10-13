/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import jakarta.persistence.Entity;

/**
 *
 * @author hophu
 */
@Entity
public class MatHang {

    private String MAMH;
    private String TENMH;
    private float GIABAN;
    private String DVT;
    private String MALOAI;
    private String MOTA;
    private String VOHIEUHOA;

    public String getMAMH() {
        return MAMH;
    }

    public void setMAMH(String MAMH) {
        this.MAMH = MAMH;
    }

    public String getTENMH() {
        return TENMH;
    }

    public void setTENMH(String TENMH) {
        this.TENMH = TENMH;
    }

    public float getGIABAN() {
        return GIABAN;
    }

    public void setGIABAN(float GIABAN) {
        this.GIABAN = GIABAN;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public String getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(String MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

    public String getVOHIEUHOA() {
        return VOHIEUHOA;
    }

    public void setVOHIEUHOA(String VOHIEUHOA) {
        this.VOHIEUHOA = VOHIEUHOA;
    }

    public MatHang(String MAMH, String TENMH, float GIABAN, String DVT, String MALOAI, String MOTA, String VOHIEUHOA) {
        this.MAMH = MAMH;
        this.TENMH = TENMH;
        this.GIABAN = GIABAN;
        this.DVT = DVT;
        this.MALOAI = MALOAI;
        this.MOTA = MOTA;
        this.VOHIEUHOA = VOHIEUHOA;
    }

    public MatHang() {
    }

    @Override
    public String toString() {
        return "MatHang{" + "MAMH=" + MAMH + ", TENMH=" + TENMH + ", GIABAN=" + GIABAN + ", DVT=" + DVT + ", MALOAI=" + MALOAI + ", MOTA=" + MOTA + ", VOHIEUHOA=" + VOHIEUHOA + '}';
    }
}