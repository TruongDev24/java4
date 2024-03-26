package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.ChiTietSP;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;


public class ChiTietSanPhamREPO {
    Session session;
    public ArrayList<ChiTietSP> getList(){
        session = HBNConnect.getFACTORY().openSession();
        //truy vấn lấy ra toàn bộ Danh mục
        ArrayList<ChiTietSP> list = (ArrayList<ChiTietSP>) session.createQuery("FROM ChiTietSP").list();
        session.close();
        return list;
    }
}
