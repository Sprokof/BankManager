package bank.dao;

import bank.entity.Client;
import lombok.Getter;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ClientDAOImpl implements ClientDAO{
    @Getter
    private final SessionFactory sessionFactory =
            new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).buildSessionFactory();
    @Override
    public void saveClient(Client client) {
        Session session  = null;
    try{
        session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }
    catch (Exception e){e.printStackTrace();}
    finally {
        this.sessionFactory.close();
    }
    }

    @Override
    public Client getClientById(int id) {
        Session session;
        Client client = null;
    try{
        session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        client = session.get(Client.class, id);
        session.getTransaction().commit();
    }
    catch (Exception e){e.printStackTrace();}
    finally {
        this.sessionFactory.close();
    }
    return client;
    }

    @Override
    public void updateClient(Client client) {
        Session session;
    try{
        session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
    }
    catch (Exception e){e.printStackTrace();}
    finally {
        this.sessionFactory.close();
    }

    }

    @Override
    public Client getClientByPassportNumber(String passportNumber) {
        Session session;
        Client client = null;
    try{
        session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        try{
            client = (Client) session.
                    createSQLQuery("SELECT * FROM CLIENTS WHERE PASSPORT_NUMBER =:pn")
                .addEntity(Client.class).setParameter("pn", passportNumber).list().get(0);}
        catch (Exception e){
            if(e instanceof IndexOutOfBoundsException){ return null; }
            e.printStackTrace();}
        session.getTransaction().commit();
    }
    catch (Exception e){e.printStackTrace();
    }
    finally{
        this.sessionFactory.close(); }

    return client;
    }

    @Override
    public void deleteClient(Client client) {
        Session session;
    try{
        session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
    }
    catch (Exception e){ e.printStackTrace();}
    finally {
        this.sessionFactory.close();
    }



    }
}
