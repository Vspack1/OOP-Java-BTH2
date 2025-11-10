/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class QuanLyHocVien {
    private final List<HocVien> ds = new ArrayList<>();
    
    public void themHv(HocVien... a){
        this.ds.addAll(Arrays.asList(a));
    }
    
    public void themHv(String tapTin) throws FileNotFoundException {
        File f = new File(tapTin); 
        try (Scanner sc = new Scanner(f)){
            while (sc.hasNext())
                this.ds.add(new HocVien(sc.nextLine(), sc.nextLine()));
        }
    }
    
    public void hienThi() {
        this.ds.forEach(h -> h.hienThi());
    }
    
    
    
    public void nhapDiem() {
        this.ds.forEach(h -> {
            System.out.printf(" -- Nhap %s -- \n", h.getHoTen().toUpperCase());
            h.nhapDiem();
        });
    }
    
    public HocVien timKiem(int id){
        return this.ds.stream().filter(h ->h.getId() == id).findFirst().get();
    }
    
    public List<HocVien> timKiem(String kw){
        return this.ds.stream().filter(h -> h.getHoTen().contains(kw)).collect(Collectors.toList());
    }
    
    public List<HocVien> timKiem() {
        return this.ds.stream().filter(h -> h.isHocBong()).collect(Collectors.toList());
    }
}
