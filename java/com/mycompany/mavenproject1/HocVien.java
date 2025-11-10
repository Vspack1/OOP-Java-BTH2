/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.time.LocalDate;
import java.util.stream.DoubleStream;

/**
 *
 * @author admin
 */
public class HocVien {
    private static int dem;
    private int id = ++dem;
    private String hoTen;
    private LocalDate ngaySinh;
    private double[] diem;
    
    public HocVien(String hoTen, LocalDate ngaySinh){
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
    }
    
    public HocVien(String hoTen, String ngaySinh){
        this(hoTen, LocalDate.parse(ngaySinh, CauHinh.FORMATTER));
    }
    
    public void hienThi() {
        System.out.printf("Id: %d\nTen: %s\nNgay sinh: %s\n", this.id
        , this.hoTen, this.ngaySinh.format(CauHinh.FORMATTER));
    }

    /**
     * @return the dem
     */
    public static int getDem() {
        return dem;
    }

    /**
     * @param aDem the dem to set
     */
    public static void setDem(int aDem) {
        dem = aDem;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the ngaySinh
     */
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the diem
     */
    public double[] getDiem() {
        return diem;
    }

    /**
     * @param diem the diem to set
     */
    public void setDiem(double[] diem) {
        this.diem = diem;
    }
    
    public void nhapDiem() {
        this.diem = new double[CauHinh.SO_MON];
        for (int i = 0; i< CauHinh.SO_MON; i++){
            System.out.printf("Nhap mon thu: %d = ", i+1);
            this.diem[i] = CauHinh.sc.nextDouble();
        }
    }
    
    public double tinhTb() {
        if (this.diem != null)
            return DoubleStream.of(this.diem).average().getAsDouble();
        return 0;
    }
    
    public boolean isHocBong() {
        if (this.diem != null){
            for (var x: this.diem)
                if (x<5)
                    return false;
            return this.tinhTb() >= 8;
        }
        
        return false;
    } 
}
