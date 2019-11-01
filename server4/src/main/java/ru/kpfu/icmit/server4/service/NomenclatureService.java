package ru.kpfu.icmit.server4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.icmit.server4.model.soap.Nomenclature;
import ru.kpfu.icmit.server4.repository.NomenclatureRepository;
import java.util.Date;
import java.util.List;

@Service
public class NomenclatureService {

    @Autowired
    private NomenclatureRepository nomenclatureRepository;

    public List<Nomenclature> getNomenclature( Date dateFrom) {
        return nomenclatureRepository.getNomenclature(dateFrom);
    }

    public Nomenclature save(Nomenclature nomenclature) {
        return nomenclatureRepository.save(nomenclature);
    }

}
