package ru.kpfu.icmit.server4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.icmit.server4.model.Nomenclature;
import ru.kpfu.icmit.server4.repository.NativeRepository;
import ru.kpfu.icmit.server4.repository.NomenclatureRepository;
import java.util.Date;
import java.util.List;

@Service
public class NomenclatureService {

    @Autowired
    private NomenclatureRepository nomenclatureRepository;

    @Autowired
    private NativeRepository nativeRepository;

    public List<Nomenclature> getNomenclature(Date dateFrom) {
        return nomenclatureRepository.getNomenclature(dateFrom);
    }


    public List<Nomenclature> getNomenclatureFromTo(int from, int to) {
        return nativeRepository.getNomenclatureFromTo(from,to);
    }

    public Nomenclature save(Nomenclature nomenclature) {
        return nomenclatureRepository.save(nomenclature);
    }

}
