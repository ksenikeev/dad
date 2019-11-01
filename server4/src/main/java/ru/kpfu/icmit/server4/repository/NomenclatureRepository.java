package ru.kpfu.icmit.server4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.kpfu.icmit.server4.model.soap.Nomenclature;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface NomenclatureRepository extends CrudRepository<Nomenclature, Long> {

    @Query("select n from Nomenclature n where uid = :uid ")
    Nomenclature findByUid(@Param("uid") UUID uid);

    @Query("select n from Nomenclature n where modifyDate >= :dateFrom ")
    List<Nomenclature> getNomenclature(@Param("dateFrom") Date dateFrom);
}
