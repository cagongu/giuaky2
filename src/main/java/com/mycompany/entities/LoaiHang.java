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
public class LoaiHang {
    private String MALOAI;
    private String TENLOAI;
    private String VOHIEUHOA;

    public LoaiHang() {
    }

    public LoaiHang(String MALOAI, String TENLOAI, String VOHIEUHOA) {
        this.MALOAI = MALOAI;
        this.TENLOAI = TENLOAI;
        this.VOHIEUHOA = VOHIEUHOA;
    }

    public String getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(String MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getTENLOAI() {
        return TENLOAI;
    }

    public void setTENLOAI(String TENLOAI) {
        this.TENLOAI = TENLOAI;
    }

    public String getVOHIEUHOA() {
        return VOHIEUHOA;
    }

    public void setVOHIEUHOA(String VOHIEUHOA) {
        this.VOHIEUHOA = VOHIEUHOA;
    }

    @Override
    public String toString() {
        return "LoaiHang{" + "MALOAI=" + MALOAI + ", TENLOAI=" + TENLOAI + ", VOHIEUHOA=" + VOHIEUHOA + '}';
    }
    
    
}
