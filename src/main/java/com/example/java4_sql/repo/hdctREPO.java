package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.HoaDonChiTiet;
import com.example.java4_sql.model.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class hdctREPO {
    Session session;
    public ArrayList<HoaDonChiTiet> getList(){
        session = HBNConnect.getFACTORY().openSession();
        ArrayList<HoaDonChiTiet> list = (ArrayList<HoaDonChiTiet>) session.createQuery("from HoaDonChiTiet").list();
        session.close();
        return list;
    }

    public void add(HoaDonChiTiet hdct) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.saveOrUpdate(hdct);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void update(HoaDonChiTiet hdct) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.update(hdct);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void delete(HoaDonChiTiet hdct) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.delete(hdct);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public HoaDonChiTiet getDetail(Integer idhdct){
        session = HBNConnect.getFACTORY().openSession();
        HoaDonChiTiet ms = (HoaDonChiTiet) session.createQuery("from HoaDonChiTiet where id = :id_1")
                .setParameter("id_1", idhdct).getSingleResult();
        session.close();
        return ms;
    }
}
