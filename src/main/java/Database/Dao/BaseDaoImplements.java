package Database.Dao;


import org.example.Table.SportInventory;
import org.example.Table.Warehouse;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDaoImplements<T> implements BaseDao<T> {

    protected abstract Class<T> getEntityClass();


    public boolean existsById(Class<?> relatedClass, int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Object found = session.get(relatedClass, id);
            return found != null;
        }
    }


    @Override
    public void save(T entity, Class<?> relatedClass, int relatedId) {
        Transaction transaction = null;
        if (!existsById(relatedClass, relatedId)) {
            throw new IllegalArgumentException("Связанный объект не существует в базе данных!");
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) transaction.rollback();
        }
    }

    @Override
    public void save(T entity) {
        Transaction transaction = null;


        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                } catch (Exception ex) {
                    ex.printStackTrace(); // лог при неудачном rollback
                }
            }
            e.printStackTrace();
        } finally {
            session.close(); // обязательно вручную закрыть
        }

    }


    @Override
    public T getById(int Id) {
        Transaction transaction = null;
        T entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            entity = session.get(getEntityClass(), Id);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null && transaction.isActive()) transaction.rollback();
        }
        return entity;
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        boolean result = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T entity = session.get(getEntityClass(), id);
            if (entity != null) {
                session.remove(session.find(getEntityClass(), id));
                result = true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) transaction.rollback();
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }

    @Override
    public List<T> getAll() {
        Transaction transaction = null;
        List<T> resultList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            resultList = session.createQuery("from " + getEntityClass().getName(), getEntityClass()).list();

            for (T entity : resultList) {
                if (entity instanceof Warehouse warehouse) {
                    Hibernate.initialize(warehouse.getInventoryList());
                } else if (entity instanceof SportInventory sportInventory) {
                    Hibernate.initialize(sportInventory.getRacket());
                    Hibernate.initialize(sportInventory.getShuttlecock());
                }

            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
        return resultList;
    }

}


