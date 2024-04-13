package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.KhachHang;
import com.example.java4_sql.model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class KhachHangREPO {
    Session session;
    public ArrayList<KhachHang> getList(){
        session = HBNConnect.getFACTORY().openSession();
        ArrayList<KhachHang> list = (ArrayList<KhachHang>) session.createQuery("from KhachHang").list();
        session.close();
        return list;
    }

    public void add(KhachHang khang) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.saveOrUpdate(khang);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void update(KhachHang khang) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.update(khang);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void delete(KhachHang khang) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.delete(khang);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public KhachHang getDetail(Integer idKH){
        session = HBNConnect.getFACTORY().openSession();
        KhachHang ms = (KhachHang) session.createQuery("from KhachHang where id = :id_1")
                .setParameter("id_1", idKH).getSingleResult();
        session.close();
        return ms;
    }

    public KhachHang searchKH(String sdt){
        session = HBNConnect.getFACTORY().openSession();
        KhachHang ms = (KhachHang) session.createQuery("from KhachHang where sdt = :sdt_1")
                .setParameter("sdt_1", sdt).getSingleResult();
        session.close();
        return ms;
    }
}
