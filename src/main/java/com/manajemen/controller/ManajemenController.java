/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manajemen.controller;

import com.manajemen.model.HibernateUtil;
import com.manajemen.model.ManajemenModel;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 *
 * @author USER
 */
public class ManajemenController {
    public void addTgs(ManajemenModel tgs){
        Transaction trx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            session.save(tgs);
            trx.commit();
        }catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateTgs(ManajemenModel tgs) {
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            session.update(tgs);
            trx.commit();
        } catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }

    }

    public void deleteTgs(int id) {
        Transaction trx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            ManajemenModel tgs = session.get(ManajemenModel.class, id);
            if(tgs != null){
                session.delete(tgs);
                System.out.println("Berhasil hapus");
            }
            trx.commit();
        } catch (Exception e){
            if (trx != null){
                trx.rollback();
            }
            e.printStackTrace();
        }

    }
    
    public List<ManajemenModel> getAllTugas() {
        Transaction trx = null;
        List<ManajemenModel> listTgs = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            trx = session.beginTransaction();
            // Using HQL (Hibernate Query Language) to fetch all records
            Query<ManajemenModel> query = session.createQuery("from ManajemenModel", ManajemenModel.class);
            listTgs = query.list(); // Fetch all results

            trx.commit(); // Commit transaction
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback(); // Rollback transaction in case of error
            }
            e.printStackTrace();
        }

        return listTgs;
    }
    
    public ManajemenModel getTgs(int id) {
        throw new UnsupportedOperationException("Not supported yet.");

    }
}
