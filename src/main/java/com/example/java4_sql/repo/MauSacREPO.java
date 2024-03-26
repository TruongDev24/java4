package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.MauSac;
import org.hibernate.Session;

import java.util.ArrayList;

public class MauSacREPO {
    Session session;
    public ArrayList<MauSac> getList(){
        session = HBNConnect.getFACTORY().openSession();
        //truy vấn lấy ra toàn bộ Danh mục
        ArrayList<MauSac> list = (ArrayList<MauSac>) session.createQuery("FROM MauSac").list();
        session.close();
        return list;
    }
}
