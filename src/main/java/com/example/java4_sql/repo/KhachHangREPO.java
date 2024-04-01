package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.KhachHang;
import org.hibernate.Session;

import java.util.ArrayList;

public class KhachHangREPO {
    Session session;
    public ArrayList<KhachHang> getList(){
        session = HBNConnect.getFACTORY().openSession();
        ArrayList<KhachHang> list = (ArrayList<KhachHang>) session.createQuery("from KhachHang").list();
        session.close();
        return list;
    }
}
