package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.SanPham;
import org.hibernate.Session;

import java.util.ArrayList;

public class SanPhamREPO {
    Session session;
    public ArrayList<SanPham> getList(){
        session = HBNConnect.getFACTORY().openSession();
        //truy vấn lấy ra toàn bộ Danh mục
        ArrayList<SanPham> list = (ArrayList<SanPham>) session.createQuery("FROM SanPham").list();
        session.close();
        return list;
    }
}
