package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void add(MauSac msac) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.saveOrUpdate(msac);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void update(MauSac msac) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.update(msac);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void delete(MauSac msac) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.delete(msac);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public MauSac getDetail(Integer idMau){
        session = HBNConnect.getFACTORY().openSession();
        MauSac ms = (MauSac) session.createQuery("from MauSac where id = :id_1")
                .setParameter("id_1", idMau).getSingleResult();
        session.close();
        return ms;
    }
}
