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
public class NhanVien {

    private String MANHANVIEN;
    private String TENNHANVIEN;
    private String DIACHI;
    private String SDT;
    private String GIOITINH;
    private String NGAYSINH;
    private String CMND_CCCD;
    private String TENDANGNHAP;
    private String MATKHAU;
    private String VOHIEUHOA;
    private String LAQUANLY;

    public NhanVien() {
    }

    public NhanVien(String MANHANVIEN, String TENNHANVIEN, String DIACHI, String SDT, String GIOITINH, String NGAYSINH, String CMND_CCCD, String TENDANGNHAP, String MATKHAU, String VOHIEUHOA, String LAQUANLY) {
        this.MANHANVIEN = MANHANVIEN;
        this.TENNHANVIEN = TENNHANVIEN;
        this.DIACHI = DIACHI;
        this.SDT = SDT;
        this.GIOITINH = GIOITINH;
        this.NGAYSINH = NGAYSINH;
        this.CMND_CCCD = CMND_CCCD;
        this.TENDANGNHAP = TENDANGNHAP;
        this.MATKHAU = MATKHAU;
        this.VOHIEUHOA = VOHIEUHOA;
        this.LAQUANLY = LAQUANLY;
    }

    public String getMANHANVIEN() {
        return MANHANVIEN;
    }

    public void setMANHANVIEN(String MANHANVIEN) {
        this.MANHANVIEN = MANHANVIEN;
    }

    public String getTENNHANVIEN() {
        return TENNHANVIEN;
    }

    public void setTENNHANVIEN(String TENNHANVIEN) {
        this.TENNHANVIEN = TENNHANVIEN;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getCMND_CCCD() {
        return CMND_CCCD;
    }

    public void setCMND_CCCD(String CMND_CCCD) {
        this.CMND_CCCD = CMND_CCCD;
    }

    public String getTENDANGNHAP() {
        return TENDANGNHAP;
    }

    public void setTENDANGNHAP(String TENDANGNHAP) {
        this.TENDANGNHAP = TENDANGNHAP;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getVOHIEUHOA() {
        return VOHIEUHOA;
    }

    public void setVOHIEUHOA(String VOHIEUHOA) {
        this.VOHIEUHOA = VOHIEUHOA;
    }

    public String getLAQUANLY() {
        return LAQUANLY;
    }

    public void setLAQUANLY(String LAQUANLY) {
        this.LAQUANLY = LAQUANLY;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "MANHANVIEN=" + MANHANVIEN + ", TENNHANVIEN=" + TENNHANVIEN + ", DIACHI=" + DIACHI + ", SDT=" + SDT + ", GIOITINH=" + GIOITINH + ", NGAYSINH=" + NGAYSINH + ", CMND_CCCD=" + CMND_CCCD + ", TENDANGNHAP=" + TENDANGNHAP + ", MATKHAU=" + MATKHAU + ", VOHIEUHOA=" + VOHIEUHOA + ", LAQUANLY=" + LAQUANLY + '}';
    }

}
