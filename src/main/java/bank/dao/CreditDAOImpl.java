package bank.dao;

import bank.entity.Credit;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreditDAOImpl implements CreditDAO{
    @Getter
    private final SessionFactory sessionFactory = new Configuration().
            configure("hibernate.cfg.xml").addAnnotatedClass(Credit.class).buildSessionFactory();

    @Override
    public void saveCredit(Credit credit) {
        Session session;
    try{
        session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(credit);
        session.getTransaction().commit();
    }
    catch (Exception e){e.printStackTrace();}
    finally{
        this.sessionFactory.close();
    }

    }

    @Override
    public Credit getCreditById(int id) {
        Session session;
        Credit credit = null;
    try{
        session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        credit = session.get(Credit.class, id);
        session.getTransaction().commit();
    }
    catch (Exception e){e.printStackTrace();}
    finally{
        this.sessionFactory.close();
    }
    return credit;
    }

    @Override
    public void updateCredit(Credit credit) {
        Session session;
    try{
        session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(credit);
        session.getTransaction().commit();
    }
    catch (Exception e){e.printStackTrace();}
    finally{
        this.sessionFactory.close();
    }

    }

    @Override
    public void deleteCredit(Credit credit) {
        Session session;
    try{
        session = this.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(credit);
        session.getTransaction().commit();
    }
    catch (Exception e){e.printStackTrace();}
    finally{
        this.sessionFactory.close();
    }

    }
}

