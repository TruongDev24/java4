package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.HoaDon;
import org.hibernate.Session;

import java.util.ArrayList;

public class HoaDonREPO {
    Session session;
    public ArrayList<HoaDon> getList(){
        session = HBNConnect.getFACTORY().openSession();
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) session.createQuery("from HoaDon").list();
        session.close();
        return list;
    }
}
