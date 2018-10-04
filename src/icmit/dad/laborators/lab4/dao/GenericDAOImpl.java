package icmit.dad.laborators.lab4.dao;

import icmit.dad.laborators.lab4.domain.Entity;
import icmit.dad.laborators.lab4.util.DbWork;

import java.sql.ResultSet;
import java.util.List;

public abstract class GenericDAOImpl<T extends Entity> implements GenericDAO<T> {

    protected DbWork db = DbWork.getInstance();

    @Override
    public abstract T create(T o);

    @Override
    public abstract void update(T o);

    @Override
    public abstract void delete(T o);

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T getByKey(Long id) {
        return null;
    }

    @Override
    public T getByName(String name) {
        return null;
    }

    @Override
    public T getByCode(String code) {
        return null;
    }

    public T getObjectFromResultSet(ResultSet rs){
        return null;
    }
}
