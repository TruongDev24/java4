package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.DanhMuc;
import com.example.java4_sql.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucREPO {
    Session session;

    public ArrayList<DanhMuc> getList() {
        session = HBNConnect.getFACTORY().openSession();
        //truy vấn lấy ra toàn bộ Danh mục
        ArrayList<DanhMuc> list = (ArrayList<DanhMuc>) session.createQuery("FROM DanhMuc").list();
        session.close();
        return list;
    }

//    public void add(DanhMuc dmuc) {
//        session = HBNConnect.getFACTORY().openSession();
//        Transaction tst = session.beginTransaction();
//        try {
//            session.saveOrUpdate(dmuc);
//            tst.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            tst.rollback();
//        }
//        session.close();
//    }

    public DanhMuc getDetail(Integer idDM) {
        Session session = HBNConnect.getFACTORY().openSession();
        DanhMuc dm = (DanhMuc) session.createQuery("FROM DanhMuc WHERE id = :id_1")
                .setParameter("id_1", idDM).getSingleResult();
        session.close();
        return dm;

    }
}
