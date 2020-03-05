package ru.kpfu.icmit.server4.repository;

import org.springframework.stereotype.Component;
import ru.kpfu.icmit.server4.model.Nomenclature;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class NativeRepository {

    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager entityManager;

    public List<Nomenclature> getNomenclatureFromTo(int from, int to) {
        Query query =
                entityManager
                        .createNativeQuery("select * from nomenclature order by id limit :to offset :from ",
                        Nomenclature.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        List<Nomenclature> result = query.getResultList();
        return result;
    }

}
