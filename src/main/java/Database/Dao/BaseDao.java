package Database.Dao;

import java.util.List;

public interface BaseDao <T>{

    List<T> getAll();

    void save(T entity);

    void save(T entity, Class<?> relatedClass, int relatedId);

    T getById(int Id);

    void delete(int id);

    void update(T entity);
}
