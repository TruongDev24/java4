package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.DanhMuc;
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

    public void add(DanhMuc dmuc) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.saveOrUpdate(dmuc);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void update(DanhMuc dmuc) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.update(dmuc);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void delete(DanhMuc dmuc) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.delete(dmuc);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public DanhMuc getDetail(Integer idDanhMuc){
        session = HBNConnect.getFACTORY().openSession();
        DanhMuc ms = (DanhMuc) session.createQuery("from DanhMuc where id = :id_1")
                .setParameter("id_1", idDanhMuc).getSingleResult();
        session.close();
        return ms;
    }
}
