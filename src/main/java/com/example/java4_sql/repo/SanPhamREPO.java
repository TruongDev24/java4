package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.DanhMuc;
import com.example.java4_sql.model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamREPO {
    Session session;

    public ArrayList<SanPham> getList() {
        session = HBNConnect.getFACTORY().openSession();
        //truy vấn lấy ra toàn bộ Danh mục
        ArrayList<SanPham> list = (ArrayList<SanPham>) session.createQuery("FROM SanPham").list();
        session.close();
        return list;
    }

    public void add(SanPham sanpham) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tst = session.beginTransaction();
        try {
            session.saveOrUpdate(sanpham);
            tst.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tst.rollback();
        }
        session.close();
    }

    public SanPham getDetail(Integer idSanPham) {
        session = HBNConnect.getFACTORY().openSession();
        SanPham sanPham = (SanPham) session.createQuery("FROM SanPham WHERE id = :id_1")
                .setParameter("id_1", idSanPham).getSingleResult();
        session.close();
        return sanPham;

    }

    public void delete(SanPham sanPham) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tst = session.beginTransaction();
        try {
            session.delete(sanPham);
            tst.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tst.rollback();
        }
        session.close();
    }

    public void update(SanPham sanPham) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tst = session.beginTransaction();
        try {
            session.update(sanPham);
            tst.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tst.rollback();
        }
        session.close();
    }
}
