package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.ChiTietSP;
import com.example.java4_sql.model.ChiTietSP;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void add(ChiTietSP Ctsp) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.saveOrUpdate(Ctsp);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void update(ChiTietSP Ctsp) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.update(Ctsp);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void delete(ChiTietSP Ctsp) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.delete(Ctsp);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public ChiTietSP getDetail(Integer idctsp){
        session = HBNConnect.getFACTORY().openSession();
        ChiTietSP ms = (ChiTietSP) session.createQuery("from ChiTietSP where id = :id_1")
                .setParameter("id_1", idctsp).getSingleResult();
        session.close();
        return ms;
    }
}
