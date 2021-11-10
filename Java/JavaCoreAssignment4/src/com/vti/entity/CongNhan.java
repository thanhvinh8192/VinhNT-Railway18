package com.vti.entity;

public class CongNhan extends CanBo{
    private int capBac;

    @Override
    public String toString() {
        return "CongNhan{" +
                "capBac=" + capBac +
                '}';
    }

    public CongNhan(){

    }

    public CongNhan(String hoTen, int tuoi, CanBo.gioiTinh gioiTinh, String diaChi, int capBac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.capBac = capBac;
    }

    public int getCapBac() {
        return capBac;
    }

    public void setCapBac(int capBac) {
        this.capBac = capBac;
    }
}
