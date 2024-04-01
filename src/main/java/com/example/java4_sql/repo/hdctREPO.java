package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.HoaDonChiTiet;
import org.hibernate.Session;

import java.util.ArrayList;

public class hdctREPO {
    Session session;
    public ArrayList<HoaDonChiTiet> getList(){
        session = HBNConnect.getFACTORY().openSession();
        ArrayList<HoaDonChiTiet> list = (ArrayList<HoaDonChiTiet>) session.createQuery("from HoaDonChiTiet").list();
        session.close();
        return list;
    }
}
