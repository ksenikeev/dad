package icmit.dad.laborators.lab5.dao;

import icmit.dad.laborators.lab5.domain.Entity;

import java.util.List;

public interface GenericDAO<T extends Entity> {
    T create(T o);
    void update(T o);
    void delete(T o);
    List<T> getAll();
    T getByKey(Long id);
    T getByName(String name);
    T getByCode(String code);
}
