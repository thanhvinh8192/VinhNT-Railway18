package com.vti.entity;

public class CanBo {
    private String hoTen;
    private int tuoi;
    private gioiTinh chonGioiTinh;
    private String diaChi;

    public  enum gioiTinh{
        NAM, NU, KHAC
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "Họ Tên: " + hoTen  +
                ", Tuổi: " + tuoi +
                ", Giới Tính: " + chonGioiTinh +
                ", Địa chỉ: " + diaChi  + '}';
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public CanBo.gioiTinh getChonGioiTinh() {
        return chonGioiTinh;
    }

    public void setChonGioiTinh(CanBo.gioiTinh chonGioiTinh) {
        this.chonGioiTinh = chonGioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public CanBo(){}

    public CanBo(String hoTen, int tuoi, CanBo.gioiTinh chonGioiTinh, String diaChi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.chonGioiTinh = chonGioiTinh;
        this.diaChi = diaChi;
    }
}
