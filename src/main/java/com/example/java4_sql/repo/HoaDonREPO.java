package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.HoaDon;
import com.example.java4_sql.model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HoaDonREPO {
    Session session;
    public ArrayList<HoaDon> getList(){
        session = HBNConnect.getFACTORY().openSession();
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) session.createQuery("from HoaDon").list();
        session.close();
        return list;
    }

    public void add(HoaDon hdon) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.saveOrUpdate(hdon);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void update(HoaDon hdon) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.update(hdon);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void delete(HoaDon hdon) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.delete(hdon);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public HoaDon getDetail(Integer idhoadon){
        session = HBNConnect.getFACTORY().openSession();
        HoaDon ms = (HoaDon) session.createQuery("from HoaDon where id = :id_1")
                .setParameter("id_1", idhoadon).getSingleResult();
        session.close();
        return ms;
    }

}
