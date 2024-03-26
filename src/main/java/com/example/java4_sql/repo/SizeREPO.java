package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.Size;
import org.hibernate.Session;

import java.util.ArrayList;

public class SizeREPO {
    Session session;
    public ArrayList<Size> getList(){
        session = HBNConnect.getFACTORY().openSession();
        //truy vấn lấy ra toàn bộ Danh mục
        ArrayList<Size> list = (ArrayList<Size>) session.createQuery("FROM Size").list();
        session.close();
        return list;
    }
}
