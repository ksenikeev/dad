package icmit.dad.laborators.lab1;

import java.util.List;

public interface GenericDAO<T> {
    T create();
    void update(T o);
    void delete(T o);
    List<T> getAll();
    T getByKey(Long id);
    T getByName(String name);
    T getByCode(String code);
}
