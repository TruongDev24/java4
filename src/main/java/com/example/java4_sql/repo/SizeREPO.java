package com.example.java4_sql.repo;

import com.example.java4_sql.Connect.HBNConnect;
import com.example.java4_sql.model.Size;
import com.example.java4_sql.model.Size;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void add(Size size) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.saveOrUpdate(size);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void update(Size size) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.update(size);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public void delete(Size size) {
        session = HBNConnect.getFACTORY().openSession();
        Transaction tsn = session.beginTransaction();
        try{
            session.delete(size);
            tsn.commit();
        } catch (Exception e){
            e.printStackTrace();
            tsn.rollback();
        }
        session.close();
    }

    public Size getDetail(Integer idSize){
        session = HBNConnect.getFACTORY().openSession();
        Size ms = (Size) session.createQuery("from Size where id = :id_1")
                .setParameter("id_1", idSize).getSingleResult();
        session.close();
        return ms;
    }
}
