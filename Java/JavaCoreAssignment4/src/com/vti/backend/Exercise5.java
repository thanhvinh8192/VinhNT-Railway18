package com.vti.backend;

import com.vti.entity.CanBo;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5 {
    Scanner input = new Scanner(System.in);
    public void QLCB(){
    }

    public void addCanBo(){
        CanBo canBo = new CanBo();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập vào họ tên cán bộ: ");
        canBo.setHoTen(input.nextLine());
        System.out.print("Nhập vào tuổi cán bộ: ");
        canBo.setTuoi(input.nextInt());
        System.out.print("""
                Nhập vào giới tính cán bộ
                Nhập 0 để chọn giới tính Nam
                Nhập 1 để chọn giới tính Nữ
                Nhập 3 để chọn giới tính Nam
                """);
        switch (input.nextInt()) {
            case 0 -> canBo.setChonGioiTinh(CanBo.gioiTinh.NAM);
            case 1 -> canBo.setChonGioiTinh(CanBo.gioiTinh.NU);
            default -> canBo.setChonGioiTinh(CanBo.gioiTinh.KHAC);
        }
        input.nextLine();
        System.out.print("Nhập vào địa chỉ cán bộ:");
        canBo.setDiaChi(input.nextLine());
        System.out.println("Thông tin cán bộ vừa nhập: " + canBo);
    }

    public CanBo findCanBoByHoTen(ArrayList<CanBo> listCanBo, String name){
        CanBo result = new CanBo();
        for (CanBo cb: listCanBo) {
            if(cb.getHoTen().equals(name)){
                result = cb;
                break;
            }else {
                System.out.println("Không tìm thấy cán bộ trong danh sách");
                result = null;
            }
        }
        return result;
    }

}
