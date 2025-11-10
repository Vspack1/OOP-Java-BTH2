/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        HocVien h1 = new HocVien("Nguyen Van A", "15/09/2001");
        HocVien h2 = new HocVien("Nguyen Van B", "20/11/2005");
        HocVien h3 = new HocVien("Nguyen Van C", "18/12/2003");
        HocVien h4 = new HocVien("Tran Van E", LocalDate.of(2002, 8, 7));
        
        QuanLyHocVien ql = new QuanLyHocVien();
//        ql.themHv(h1, h2, h3, h4);
        try {
            ql.themHv("src/main/resources/hocvien.txt");
        } catch (FileNotFoundException ex){
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ql.hienThi();
        
        System.out.println("-----");
        
        ql.nhapDiem();
        ql.hienThi();
        
        System.out.println("-----");
        
        ql.timKiem().forEach(h -> h.hienThi());
        
    }
}
